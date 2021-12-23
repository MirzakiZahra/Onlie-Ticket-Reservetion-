package main.java.dao;

import main.java.entity.City;
import main.java.entity.Ticket;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CityService {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addCityByManager(City city) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();

    }
    public City findCity(String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from City where name= :name";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(City.class);
        query.setParameter("name", name);
        City city= (City) query.list().get(0);
        transaction.commit();
        session.close();
        return city;
    }
}
