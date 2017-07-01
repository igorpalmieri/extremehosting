package DAO;

import Model.Stay;
import Model.User;
import java.util.List;
import org.hibernate.Session;

public class StayDAO {
    
    static Session session = HibernateSessionFactory.getSession(); 
    
    public static void save(Stay stay){
        session.beginTransaction();
	session.merge(stay);
        session.getTransaction().commit();
    }
    
    public static List<Stay> getStaysByHouseOwner(User user){
        return null;
    }
    
}
