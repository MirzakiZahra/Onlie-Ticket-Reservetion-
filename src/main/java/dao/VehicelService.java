package main.java.dao;

import main.java.entity.City;
import main.java.entity.Vehicle;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VehicelService {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addVehicel(Vehicle vehicle) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(vehicle);
        transaction.commit();
        session.close();

    }
    public Vehicle findVehicel(int plaque){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from Vehicel where plaque= :nplaque";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Vehicle.class);
        query.setParameter("plaque", plaque);
        Vehicle vehicle= (Vehicle) query.list().get(0);
        transaction.commit();
        session.close();
        return vehicle;
    }
}
