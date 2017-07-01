package DAO;

import Model.Rate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

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
}
