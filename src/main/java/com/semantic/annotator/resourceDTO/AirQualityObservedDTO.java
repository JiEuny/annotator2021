package com.semantic.annotator.resourceDTO;

import com.semantic.annotator.resource.AirQualityObserved;
import lombok.Data;

@Data
public class AirQualityObservedDTO {

    private String id;                  //getId()   
    private String observedValue;      //getAirQualityObservation().getValue()
    private String indexRef;            //getIndexRef().getValue();
    private String evaluationValue;    //getAirQualityObservation().getValue()
    private String locationName1 = "addressCountry";
    private String addressCountry;      
    private String locationName2 = "addressRegion";
    private String addressRegion;
    private String locationName3 = "addressLocality";
    private String addressLocality;
    private String locationName4 = "streetAddress";
    private String streetAddress; 
    private String locationName5 = "addressTown";
    private String addressTown; 
    private String locationType;
    private String latitude;
    private String longitude;
    private String modifiedAt;
    private String createdAt;
    private String observedAt;         // getAirQualityObservation().getObservedAt()

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt.split(",")[0]+"+09:00";
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt.split(",")[0]+"+09:00";
    }

    public void setObservedAt(String observedAt) {
        this.observedAt = observedAt.split(",")[0]+"+09:00";
    }

    public String getOrder(int i) {
        String result = "";
        switch (i) {
            case 0: result = id; break;
            case 1: result = observedValue; break;
            case 2: result = indexRef; break;
            case 3: result = evaluationValue; break;
            case 4: result = locationName1; break;
            case 5: result = addressCountry; break;
            case 6: result = locationName2; break;
            case 7: result = addressRegion; break;
            case 8: result = locationName3; break;
            case 9: result = addressLocality; break;
            case 10: result = locationName4; break;
            case 11: result = streetAddress; break;
            case 12: result = locationName5; break;
            case 13: result = addressTown; break;
            case 14: result = locationType; break;
            case 15: result = latitude; break;
            case 16: result = longitude; break;
            case 17: result = modifiedAt; break;
            case 18: result = createdAt; break;
            case 19: result = observedAt; break;
        }
        return result;
    }
}
