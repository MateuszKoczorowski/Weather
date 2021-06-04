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
        LocationService locationService = new LocationService(locationRepositoryImpl);
        LocationController locationController = new LocationController(locationService);
        UserInterface userInterface = new UserInterface(locationController);
        userInterface.run();
    }
}
