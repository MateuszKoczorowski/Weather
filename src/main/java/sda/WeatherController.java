package sda;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.WatchService;

public class WeatherController {

        private WeatherService weatherService = new WeatherService();
        private ObjectMapper objectMapper = new ObjectMapper();

    public String createNewLocation (String nameLocation, double x , double y , String region , String country) {
try {
    Weather newWeather = weatherService.createNewLocation(nameLocation,x,y,region,country);
    return objectMapper.writeValueAsString(newWeather);
} catch (Exception e) {
   return "{\"error message\": \""+e.getMessage()+"\"}";
}
    }
}

