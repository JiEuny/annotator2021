package com.semantic.annotator.resourceDTO;

import lombok.Data;

@Data
public class WeatherObservedDTO {
    private String id;
    private String weatherObservation;
    private String weatherEvaluationHasRecord;
    private String addressName1 = "addressCountry";
    private String addressCountry;
    private String addressName2 = "addressRegion";
    private String addressRegion;
    private String addressName3 = "addressLocality";
    private String addressLocality;
    private String addressName4 = "streetAddress";
    private String streetAddress;
    private String addressName5 = "addressTown";
    private String addressTown;
    private String locationType;
    private String latitute;
    private String longitude;
    private String modifiedAt;
    private String createdAt;
    private String observedAt;

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
            case 1: result = weatherObservation; break;
            case 2: result = weatherEvaluationHasRecord; break;
            case 3: result = addressName1; break;
            case 4: result = addressCountry; break;
            case 5: result = addressName2; break;
            case 6: result = addressRegion; break;
            case 7: result = addressName3; break;
            case 8: result = addressLocality; break;
            case 9: result = addressName4; break;
            case 10: result = streetAddress; break;
            case 11: result = addressName5; break;
            case 12: result = addressTown; break;
            case 13: result = locationType; break;
            case 14: result = latitute; break;
            case 15: result = longitude; break;
            case 16: result = modifiedAt; break;
            case 17: result = createdAt; break;
            case 18: result = observedAt; break;
        }
        return result;
    }
}
