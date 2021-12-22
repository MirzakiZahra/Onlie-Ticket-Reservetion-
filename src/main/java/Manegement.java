package main.java;

import main.java.entity.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Manegement {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addCityByManager(City city) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();

    }
    public 
}
