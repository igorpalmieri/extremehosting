package DAO;

import Model.User;
import org.hibernate.Session;


public class UserDAO {

    public static void insert(User user){
        Session session = HibernateSessionFactory.getSession(); 
        session.beginTransaction();
	session.save(user); 
        session.getTransaction().commit();
	session.close();
    }
   
    public static User getActiveUser(String username){
        Session session = HibernateSessionFactory.getSession(); 
        session.beginTransaction();
        User user = (User) (session.createQuery("from User where Username = ?").setString(0, username).list().get(0));
        return user;
    }
    
    public static User getActiveUser(Long id){
        Session session = HibernateSessionFactory.getSession(); 
        session.beginTransaction();
        User user = (User) session.load(User.class,id);
        return user;
    }
}
