package DAO;

import Model.Rate;
import Model.Stay;
import Model.TypeRate;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class RateDAO {
    
    static Session session = HibernateSessionFactory.getSession(); 
    
    public static void save(Rate rate){
        session.beginTransaction();
        rate.setCreated(new Date());
	session.saveOrUpdate(rate); 
        session.getTransaction().commit();
    }
        
    public static List<Rate> getRates(Long UserId){
        List<Rate> rates = (List<Rate>) session.createQuery("FROM Rate R where R.Receiver.Id = "+UserId).list();
        return rates;
    }
      
    public static List<Rate> getPersonalRatesByUser(Long senderId, Long receiverId){
        List<Rate> rates = (List<Rate>) session.createQuery("FROM Rate R where R.Receiver.Id = :receiverId AND R.Sender.Id = :senderId AND R.Type = :type")
                .setParameter("senderId",senderId )
                .setParameter("receiverId",receiverId )
                .setParameter("type", TypeRate.PERSONAL )
                .list();
        return rates;
    }
     
    public static List<Rate> getRates(Stay stay){
        Query q = session.createQuery("FROM Rate WHERE stay = :stay").setParameter("stay", stay);
        List<Rate> rates = (List<Rate>) q.list();
        return rates;
    }
}
