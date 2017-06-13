package DAO;

import Model.Rate;
import java.util.List;
import org.hibernate.Session;

public class RateDAO {
    
    public static void insert(Rate rate){
        Session session = HibernateSessionFactory.getSession(); 
        session.beginTransaction();
	session.save(rate); 
        session.getTransaction().commit();
	session.close();
    }
    
      public static List<Rate> getRates(Long UserId){
         Session session = HibernateSessionFactory.getSession(); 
        session.beginTransaction();
        List<Rate> rates = (List<Rate>) session.createQuery("FROM Rate R where R.Receiver.Id = "+UserId).list();
        return rates;
    }
}
