package sda;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherService {
    private WeatherRepository weatherRepository = new WeatherRepository();
    private ObjectMapper objectMapper = new ObjectMapper();

    public WeatherService(){this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }
    public Weather createNewLocation (String nameLocation, double x , double y , String region , String country) {
        if (nameLocation == null || nameLocation.isEmpty()) {
            throw new RuntimeException("Nazwa miasta nie może być pusta");
        }
        if (region == null || region.isEmpty()) {
            throw new RuntimeException("Nazwa regionu nie może być pusta");
        }
        if (country == null || country.isEmpty()) {
            throw new RuntimeException("Nazwa kraju nie może być pusta");
        }
        Weather weather = new Weather(null, nameLocation, x,y,region,country);

        return weatherRepository.save(weather);
    }


}
