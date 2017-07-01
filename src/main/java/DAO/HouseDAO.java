package DAO;

import Model.House;
import Model.User;
import java.util.List;
import org.hibernate.Session;


public class HouseDAO {

    static Session session = HibernateSessionFactory.getSession(); 
     
    public static void insert(User user){
    }
    
    public static List<String> getCountries(){
       return session.createQuery("SELECT DISTINCT Country FROM House").list();
    }
    public static List<String> getCities(String country){
       return session.createQuery("SELECT DISTINCT City FROM House WHERE Country = :country").setParameter("country", country).list();
    }

    public static List<House> getAvailableHouses(String country, String city, int quantity) {
       return session.createQuery("FROM House WHERE Country = :country AND City = :city AND vacancy >= :quantity")
               .setParameter("country", country)
               .setParameter("city", city)
               .setParameter("quantity",quantity)
               .list();
    }
    
    public static House getHouse(Long id){
        return session.find(House.class, id);
    }
   
}
