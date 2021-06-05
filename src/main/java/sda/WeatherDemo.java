package sda;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class WeatherDemo {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        LocationRepositoryImpi locationRepositoryImpl = new LocationRepositoryImpi(sessionFactory);
        ForecastRepositoryImpl forecastRepositoryImpl = new ForecastRepositoryImpl(sessionFactory);

        LocationService locationService = new LocationService(locationRepositoryImpl);
        ForecastService forecastService = new ForecastService(forecastRepositoryImpl, locationRepositoryImpl);

        LocationController locationController = new LocationController(locationService);
        ForecastController forecastController = new ForecastController(forecastService);

        UserInterface userInterface = new UserInterface(locationController, forecastController);
        userInterface.run();
    }
}
