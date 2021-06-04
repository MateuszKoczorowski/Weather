package sda;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class LocationController{

        private  final LocationService locationService;
        private ObjectMapper objectMapper = new ObjectMapper();

        public LocationController (LocationService locationService) {
            this.locationService = locationService;
        }
        public String createNewLocation(String cityName, Double length , Double longitude , String region, String country) {
            try {
                Location Location = locationService.createNewLocation(cityName, length, longitude, region, country);
                return objectMapper.writeValueAsString(Location);
            } catch (Exception e) {
                return "eroor : " + e.getMessage() + "\"}";
            }
        }
            public String showAllLocation() {
                try {
                    List<Location> locations = locationService.showAllLocation();
                    return objectMapper.writeValueAsString(locations);
                } catch (Exception e) {
                    return "error : " + e.getMessage();
                }
            }
}

