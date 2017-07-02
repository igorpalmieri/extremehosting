package DAO;

import Model.StatusStay;
import Model.Stay;
import Model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
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
    public static List<Stay> getStaysByGuest(User user){
        return session.createQuery("FROM Stay WHERE guest = :guest")
                .setParameter("guest", user).list();
    }
    public static Stay getStayById(Long id){
        return session.find(Stay.class, id);
    }
    
    public static void submitApproval(Stay s, boolean approve){
        session.beginTransaction();
        s.submitApproval(approve);
        if(approve){
            List<Stay> sts = s.getHouse()
                    .getStays()
                    .stream()
                    .filter(st -> (st.isConflict(s.getStartdate(), s.getEnddate()) && !Objects.equals(st.getId(), s.getId())))
                    .collect(Collectors.toList());
            sts.forEach(st -> st.setStatus(StatusStay.REPROVADO));
            sts.forEach(st -> session.merge(st));
        }
        session.merge(s);
        session.getTransaction().commit();
    }
    
    public static void cancelRequest(Stay s){
        session.beginTransaction();
        session.remove(s);
        session.getTransaction().commit();
    }
    
}
