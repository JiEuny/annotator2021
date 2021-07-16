package com.semantic.annotator.resource;

public class AirQualityObserved {

    private String id;
    private String type;
    private Location location;
    private Address address;
    private String createdAt;
    private String modifiedAt;
    private IndexRef indexRef;
    private AirQualityObservation airQualityObservation;
    private AirQualityIndexObservation airQualityIndexObservation;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Location getLocation() {
        return location;
    }

    public Address getAddress() {
        return address;
    }

    public class AirQualityObservation {
        private String observedAt;
        private String type;
        private Object value;
//        private AirQualityObservationValue value;
//        private String airQualityObservation;

        public String getObservedAt () {
            return observedAt;
        }

        public Object getValue() {
            return value;
        }
        //        public class AirQualityObservationValue {
//            private Number no2;
//            private Number o3;
//            private Number pm25;
//            private Number so2;
//            private Number pm10;
//
//            private Number co;
//
//            public Number getNO2() {
//                return no2;
//            }
//
//            public Number getO3() {
//                return o3;
//            }
//
//            public Number getPM25() {
//                return pm25;
//            }
//
//            public Number getSO2() {
//                return so2;
//            }
//
//            public Number getPM10() {
//                return pm10;
//            }
//            public Number getCO() {
//                return co;
//            }
//
//        }
//
//        public AirQualityObservationValue getValue() {
//            return value;
//        }
//
//        public String getAirQualityObservation() {
//            return airQualityObservation;
//        }
    }

    public AirQualityObservation getAirQualityObservation() {
        return airQualityObservation;
    }


    public class AirQualityIndexObservation {
        private String observedAt;
        private String type;
        private Object value;
//        private AirQualityIndexObservationValue value;
//        private String airQualityIndexObservation;

        public String getObservedAt() {
            return observedAt;
        }

        public Object getValue() {
            return value;
        }

        //        public class AirQualityIndexObservationValue {
//            private Number totalIndex;
//            private String totalCategory;
//            private String pm10Category;
//            private String o3Category;
//            private String pm25Category;
//            private String no2Category;
//            private String coCategory;
//            private String so2Category;
//
//            public Number getTotalIndex() {
//                return totalIndex;
//            }
//
//            public String getTotalCategory() {
//                return totalCategory;
//            }
//
//            public String getPM10Category() {
//                return pm10Category;
//            }
//
//            public String getO3Category() {
//                return o3Category;
//            }
//
//            public String getPM25Category() {
//                return pm25Category;
//            }
//
//            public String getNO2Category() {
//                return no2Category;
//            }
//
//            public String getCOCategory() {
//                return coCategory;
//            }
//
//            public String getSO2Category() {
//                return so2Category;
//            }
//
//        }
//
//        public AirQualityIndexObservationValue getValue() {
//            return value;
//        }
//
//        public String getAirQualityIndexObservation() {
//            return airQualityIndexObservation;
//        }
    }

    public AirQualityIndexObservation getAirQualityIndexObservation() {
        return airQualityIndexObservation;
    }

    public class IndexRef {
        private String type;
        private String value;

        public Object getValue() {
            return value;
        }
    }

    public IndexRef getIndexRef() {
        return indexRef;
    }
}
