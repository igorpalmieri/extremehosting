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
    
    public static User getUser(String username, String password){
        Session session = HibernateSessionFactory.getSession(); 
        try{
        User user = (User) (session.createQuery("from User where Username = :username and Password = :password")                
                .setParameter("username", username)
                .setParameter("password", password).list().get(0));
        return user;
        }catch(IndexOutOfBoundsException ex){
            return null;
        }
    }
    
    public static User getUser(Long id){
        Session session = HibernateSessionFactory.getSession(); 
        User user = session.find(User.class, id);
        return user;
    }
}
