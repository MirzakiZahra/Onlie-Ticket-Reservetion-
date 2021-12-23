package main.java.dao;

import main.java.entity.City;
import main.java.entity.Ticket;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TicketService {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public Ticket findTicket(int barcode) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from Ticket where barcode= :barcode";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Ticket.class);
        query.setParameter("barcode", barcode);
        Ticket ticket = (Ticket) query.list().get(0);
        transaction.commit();
        session.close();
        return ticket;

    }
}
