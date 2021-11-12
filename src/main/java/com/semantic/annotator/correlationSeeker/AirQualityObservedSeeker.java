package com.semantic.annotator.correlationSeeker;

import com.semantic.annotator.resource.AirQualityObserved;
import com.semantic.annotator.resourceDTO.AirQualityObservedDTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class AirQualityObservedSeeker {

    private MapperFactory mapperFactory;

    public AirQualityObservedSeeker() {
        this.mapperFactory = new DefaultMapperFactory.Builder().build();
        this.mapperFactory.classMap(AirQualityObserved.class, AirQualityObservedDTO.class).
                mapNulls(false).
                mapNullsInReverse(false).
                byDefault().
                field("pm10.value", "evaluationValue").
                field("refDevice.object", "indexRef").
                field("address.value.addressCountry", "addressCountry").
                field("address.value.addressRegion", "addressRegion").
                field("address.value.addressLocality", "addressLocality").
                field("address.value.streetAddress", "streetAddress").
                field("address.value.addressTown", "addressTown").
                field("location.value.type","locationType").
                field("location.value.coordinates[0]","longitude").
                field("location.value.coordinates[1]","latitude").
                field("pm10.observedAt","observedAt").
                register();

    }

    public <S, D> D map(S s, Class<D> type)
    {
        return this.mapperFactory.getMapperFacade().map(s, type);
    }
}
