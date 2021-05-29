package sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class WeatherRepository {
    private SessionFactory sessionFactory;

    public WeatherRepository(){
        StandardServiceRegistry  registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

    }
    public Weather save (Weather weather){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(weather);
        transaction.commit();
        session.close();
        return weather;

    }
}
