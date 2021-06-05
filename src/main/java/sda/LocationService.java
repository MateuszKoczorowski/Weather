package sda;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class LocationService {
    private  LocationRepository locationRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Location createNewLocation(String cityName, Double latitude, Double longitude, String region, String country) {
        if (longitude < -90 || longitude > 90) {
            throw new RuntimeException("Dłogość geograficzna powina mieściś sie w przedziale -90 do 90 ");
        }
        if (latitude < -180 || latitude > 180) {
            throw new RuntimeException("Szerokość geograficzna powina mieściś sie w przedziale -180 do 180 ");
        }
        if (cityName.isEmpty() || cityName == null) {
            throw new RuntimeException("Pole Miasto nie może być puste");
        }
        if (region != null && region.isEmpty()) {
            throw new RuntimeException("Pole region nie może być puste");
        }

        if (country.isEmpty() || cityName == null) {
            throw new RuntimeException("Pole kraj nie może być puste");
        }
        Location location = new Location(null, cityName,latitude,longitude,region,country);
        return locationRepository.save(location);

    }
    public List<Location> showAllLocation() {
        if (locationRepository.getAllLocations().isEmpty()) {
            throw new RuntimeException("Lista kraji jest pusta");
        }
        return locationRepository.getAllLocations();

    }
}
