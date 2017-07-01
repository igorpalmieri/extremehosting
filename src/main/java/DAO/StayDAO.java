package DAO;

import Model.Stay;
import Model.User;
import java.util.ArrayList;
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
        List<Stay> stays = new ArrayList<>();
        HouseDAO.getHousesByUser(user).forEach(t -> stays.addAll(t.getStays()));
        return stays;
    }
    
    public static Stay getStayById(Long id){
        return session.find(Stay.class, id);
    }
    
    public static void submitApproval(Stay s, boolean approve){
        session.beginTransaction();
        s.submitApproval(approve);
        session.merge(s);
        session.getTransaction().commit();
    }
    
}
