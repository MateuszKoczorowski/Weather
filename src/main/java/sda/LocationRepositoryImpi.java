package sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class LocationRepositoryImpi implements LocationRepository {
    private SessionFactory sessionFactory;

    public LocationRepositoryImpi(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Location save(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(location);
        transaction.commit();
        return location;

    }

    @Override
    public List<Location> getAllLocations() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Location> locations = session.createQuery("", Location.class)
                .getResultList();
        transaction.commit();
        session.close();
        return locations;
    }

    @Override
    public Optional<Location> findById(Long id) {
        return Optional.empty();

    }

}
