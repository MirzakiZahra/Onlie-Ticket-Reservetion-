package main.java.dao;

import main.java.entity.Ticket;
import main.java.entity.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserService {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public User findUser(int nationalCode) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from User where nationalCode= :nationalCode";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(User.class);
        query.setParameter("nationalCode", nationalCode);
        User user = (User) query.list().get(0);
        transaction.commit();
        session.close();
        return user;


    }
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }
    public void addUser(User user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
}
