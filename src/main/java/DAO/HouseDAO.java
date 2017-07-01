package DAO;

import Model.House;
import Model.User;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;


public class HouseDAO {

    static Session session = HibernateSessionFactory.getSession(); 
     
    public static void save(House house){
        session.beginTransaction();
	session.saveOrUpdate(house); 
        session.getTransaction().commit();
    }
    
    public static List<String> getCountries(){
       return session.createQuery("SELECT DISTINCT Country FROM House").list();
    }
    public static List<String> getCities(String country){
       return session.createQuery("SELECT DISTINCT City FROM House WHERE Country = :country").setParameter("country", country).list();
    }

    public static List<House> getAvailableHouses(String country, String city, int quantity,Date start,Date end) {
      List<House> hs = (List<House>) session.createQuery("FROM House WHERE Country = :country AND City = :city AND capacity >= :quantity")
               .setParameter("country", country)
               .setParameter("city", city)
               .setParameter("quantity",quantity).list();
      return hs.stream()
        .filter(h -> ((House)h).getVacancy(start, end) >= quantity)
        .collect(Collectors.toList());
    }
    
    public static House getHouse(Long id){
        return session.find(House.class, id);
    }
   
 
    public static List<House> getHousesByUser(User user) {
       List<House> hs = session.createQuery("FROM House WHERE owner = :owner")
               .setParameter("owner", user)
               .list();
       hs.forEach(h -> session.refresh(h));
       hs.forEach(h -> h.getStays().forEach(s -> session.refresh(s)));
       return hs;
    }
}
