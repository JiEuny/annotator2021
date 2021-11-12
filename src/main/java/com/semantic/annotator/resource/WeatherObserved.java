package com.semantic.annotator.resource;

import lombok.Data;

import java.util.ArrayList;

@Data
public class WeatherObserved {

    private String id;
    private String type;
    private String createdAt;
    private String modifiedAt;
    private Atomespheric atom;
    private Humidity humidity;
    private Location location;
    private Source source;
    private Temperature temperature;
    private String observedValue;
    private Address address;

    @Data
    public class Atomespheric {
        private String observedAt;
        private String type;
        private Double value;
    }

    @Data
    public class Humidity {
        private String observedAt;
        private String type;
        private Double value;
    }

    @Data
    public class Source {
        private String type;
        private String value;
    }

    @Data
    public class Temperature {
        private String observedAt;
        private String type;
        private Double value;
    }

    public String getObservedValue() {

        ArrayList<Object> hub_data = new ArrayList<>();
        if (atom!=null)
            hub_data.add("\"so2\": " + atom.getValue());
        if (humidity!=null)
            hub_data.add("\"so2\": " + humidity.getValue());
        if (temperature!=null)
            hub_data.add("\"so2\": " + temperature.getValue());
        return hub_data.toString();
    }

    public static class WeatherObservation {
        private String type;
        private String observedAt;
//        private WeatherObservationValue value;
//        private String weatherObservation;
//        private String weatherEvaluationHasRecord;
        private Object value;

        public Object getValue() {
            return value;
        }

//        public String getType() {
//            return type;
//        }

        public String getObservedAt() {
            return observedAt;
        }

//        private class WeatherObservationValue {
//            private Number temperature;
//            private Number windSpeed;
//            private Number humidity;
//            private Number rainfall;
//            private Number hourlyRainfall;
//            private String rainType;
//            private Number snowfall;
//            private Number visibility;
//
//            public Number getTemperature() {
//                return temperature;
//            }
//
//            public Number getWindSpeed() {
//                return windSpeed;
//            }
//
//            public Number getHumidity() {
//                return humidity;
//            }
//
//            public Number getRainfall() {
//                return rainfall;
//            }
//
//            public Number getHourlyRainfall() {
//                return hourlyRainfall;
//            }
//
//            public String getRainType() {
//                return rainType;
//            }
//
//            public Number getSnowfall() {
//                return snowfall;
//            }
//
//            public Number getVisibility() {
//                return visibility;
//            }
//        }
//        public WeatherObservationValue getValue() {
//            return value;
//        }
//        public String getWeatherObservation() {
//            return weatherObservation;
//        }
//        public String getWeatherEvaluationHasRecord() {
//            return weatherEvaluationHasRecord;
//        }
    }

//    public WeatherObservation getWeatherObservation() {
//        return weatherObservation;
//    }
}
