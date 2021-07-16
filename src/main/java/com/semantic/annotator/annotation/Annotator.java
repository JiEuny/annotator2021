package com.semantic.annotator.annotation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.semantic.annotator.validation.Validator;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import virtuoso.jena.driver.VirtModel;
import virtuoso.jena.driver.VirtuosoUpdateFactory;
import virtuoso.jena.driver.VirtuosoUpdateRequest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Annotator {

    FileReader reader = null;
    static String type = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";
    static String nameIndivual_type = "http://www.w3.org/2002/07/owl#Namedindividual";
    static String url = "jdbc:virtuoso://172.20.0.129:1111";

    public Annotator(String graph_name, String template, String entity_id, ArrayList<String> hub_data, Validator validator) {

        ArrayList<String> Domain_list = new ArrayList<>();
        ArrayList<String> typeList = new ArrayList<>();

        try {
            reader = new FileReader(System.getProperty("user.dir")+template);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Model model = ModelFactory.createDefaultModel();
        JsonParser parser = new JsonParser();

        JsonElement jsonElement = parser.parse(reader);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Iterator<Map.Entry<String,JsonElement>> iterator = jsonObject.entrySet().iterator();  //iterator 안에서 key, value 를 가져 올 수 있음

        while (iterator.hasNext()) {

            Map.Entry<String, JsonElement> temp = iterator.next();
            if(temp.getValue().isJsonArray()) {
                for(int i=0; i<temp.getValue().getAsJsonArray().size(); i++) {
                    if(temp.getKey().equals("type-list")) {
                        JsonArray tempArray = temp.getValue().getAsJsonArray();
                        typeList.add(tempArray.get(i).toString().replaceAll("\"",""));
                    } else if(temp.getKey().equals("individual-list")) {
                        JsonArray tempArray = temp.getValue().getAsJsonArray();
                        Domain_list.add(tempArray.get(i).toString().replaceAll("\"","")+"_"+entity_id);
                        Node domain = NodeFactory.createURI(tempArray.get(i).toString().replaceAll("\"","")+"_"+entity_id);
                        Node type_d = NodeFactory.createURI(type);
                        Node range = NodeFactory.createURI(typeList.get(i));

                        Triple triples = new Triple(domain, type_d, range);
                        model.add(model.asStatement(triples));

                        domain = NodeFactory.createURI(Domain_list.get(i));
                        type_d = NodeFactory.createURI(type);
                        range = NodeFactory.createURI(nameIndivual_type);

                        triples = new Triple(domain, type_d, range);
                        model.add(model.asStatement(triples));

                    } else if(temp.getKey().equals("object-properties")) {
                        JsonArray properties = temp.getValue().getAsJsonArray();
                        JsonElement triple = properties.get(i);
                        JsonObject element = triple.getAsJsonObject();

                        Node domain = NodeFactory.createURI(element.get("domain").toString().replaceAll("\"","")+"_"+entity_id);
                        Node type_d = NodeFactory.createURI(element.get("property").toString().replaceAll("\"",""));
                        Node range;

                        if(element.get("property").toString().equals("\"http://www.w3.org/2006/time#dayOfWeek\"")) {
                            range = NodeFactory.createURI(element.get("range").toString().replaceAll("\"",""));
                        } else {
                            range = NodeFactory.createURI(element.get("range").toString().replaceAll("\"","")+"_"+entity_id);
                        }

                        Triple triples = new Triple(domain, type_d, range);
                        model.add(model.asStatement(triples));
                    } else if(temp.getKey().equals("data-properties")) {
                        JsonArray properties = temp.getValue().getAsJsonArray();
                        JsonElement triple = properties.get(i);
                        JsonObject element = triple.getAsJsonObject();

                        Node domain = NodeFactory.createURI(element.get("domain").toString().replaceAll("\"","")+"_"+entity_id);
                        Node type_d = NodeFactory.createURI(element.get("property").toString().replaceAll("\"",""));

                        XSDTypeMaker typeMaker = new XSDTypeMaker();
                        XSDDatatype datatype = typeMaker.getXSDType(element.get("range").toString());
                        Node range = NodeFactory.createLiteralByValue(datatype.parse(hub_data.get(i)), datatype);

                        Triple triples = new Triple(domain, type_d, range);
                        model.add(model.asStatement(triples));

                    }
                }
            }
        }

        validator.createOWLOntologyFromInstance(model);

        try {

            if( validator.isConsistent() && validator.isEntailed() ) {

                System.out.println("Validator work");

                VirtModel vm = VirtModel.openDatabaseModel(graph_name, url, "dba", "dba");
                String drop_graph_query = "DROP SILENT GRAPH <" + graph_name +">";
                VirtuosoUpdateRequest virtuosoUpdateRequest = VirtuosoUpdateFactory.create(drop_graph_query, vm);
                virtuosoUpdateRequest.exec();
                System.out.println("<" + graph_name + "> drop graph");
                vm.add(model);
                System.out.println("<" + graph_name + "> " + model.size()+ " triples created");
                vm.close();
            }
        } catch ( Validator.NullOntologyException e) {

        }





    }
}
