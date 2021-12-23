package main.java;

import main.java.entity.City;
import main.java.entity.Ticket;
import main.java.entity.User;
import org.hibernate.SQLQuery;
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

    public int checkExitOfCity(String nameCity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from city where name = :nameCity";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(City.class);
        query.setParameter("name", nameCity);
        int output = (Integer) query.list().size();
        session.close();
        return output;

    }

    public void addTicketByManager(Ticket ticket) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ticket);
        transaction.commit();
        session.close();
    }


  //  public void buyingTicket(User user,){


   // }
}
