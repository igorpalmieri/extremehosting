package DAO;

import Model.Stay;
import org.hibernate.Session;

public class StayDAO {
    
    static Session session = HibernateSessionFactory.getSession(); 
    
    public static void save(Stay stay){
        session.beginTransaction();
	session.merge(stay);
        session.getTransaction().commit();
    }
    
}
