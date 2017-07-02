package DAO;

import Model.User;
import org.hibernate.Session;


public class UserDAO {

    static Session session = HibernateSessionFactory.getSession(); 
     
    public static void insert(User user){
        session.beginTransaction();
	session.save(user); 
        session.getTransaction().commit();
    }
    
    public static User getUser(String username, String password){
        try{
        return (User) (session.createQuery("from User where Username = :username and Password = :password")                
                .setParameter("username", username)
                .setParameter("password", password).list().get(0));
        }catch(IndexOutOfBoundsException ex){
            return null;
        }
    }
    
    public static User getUser(Long id){
        return session.find(User.class, id);
    }
}
