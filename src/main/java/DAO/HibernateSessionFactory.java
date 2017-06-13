package DAO;

import Model.Rate;
import Model.User;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;
    
    public static Session getSession() {
        if(sessionFactory == null){
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
            try {
                    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                    StandardServiceRegistryBuilder.destroy( registry );
                    throw e;
            }

        }
        return sessionFactory.openSession();
    }
    
    private static void FillDB(){
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        
        User user = new User();
        user.setName("Igor Antunes");
        user.setCity("Rio de Janeiro");
        user.setCountry("Brazil");
        user.setHost(true);
        user.setUsername("igorantunes");
        user.setPassword("teste");
        user.setProfileURL("fileserver/profiles/igor.jpg");
        s.save(user);
        
        User user2 = new User();
        user2.setName("Igor Blackman");
        user2.setCity("Niterói");
        user2.setCountry("Brazil");
        user2.setHost(true);
        user2.setUsername("igorblackman");
        user2.setPassword("teste");
        user2.setProfileURL("fileserver/profiles/igorblackman.jpg");
        s.save(user2);
        
        User user3 = new User();
        user3.setName("Paulo Henrique Borges");
        user3.setCity("Nova Friburgo");
        user3.setCountry("Brazil");
        user3.setHost(false);
        user3.setUsername("phborges");
        user3.setPassword("teste");
        user3.setProfileURL("fileserver/profiles/paulo.jpg");
        s.save(user3);
        
        
        Rate rate = new Rate();
        rate.setSender(user);
        rate.setReceiver(user2);
        rate.setDescription("Ótima pessoa");
        rate.setType(0);
        rate.setValue(4);
        rate.setCreated(new Date());
        s.save(rate);
        
        rate = new Rate();
        rate.setSender(user3);
        rate.setReceiver(user2);
        rate.setDescription("Ótimo Host");
        rate.setType(1);
        rate.setValue(5);
        rate.setCreated(new Date());
        s.save(rate);
        
          rate = new Rate();
        rate.setSender(user2);
        rate.setReceiver(user3);
        rate.setDescription("Ótimo Host");
        rate.setType(1);
        rate.setValue(5);
        rate.setCreated(new Date());
        s.save(rate);
        
        rate = new Rate();
        rate.setSender(user);
        rate.setReceiver(user2);
        rate.setDescription("Péssimo Guest");
        rate.setType(2);
        rate.setValue(1);
        rate.setCreated(new Date());
        s.save(rate);
        
        rate = new Rate();
        rate.setSender(user);
        rate.setReceiver(user2);
        rate.setDescription("Péssimo Guest");
        rate.setType(2);
        rate.setValue(1);
        rate.setCreated(new Date());
        s.save(rate);
        
        
        rate = new Rate();
        rate.setSender(user2);
        rate.setReceiver(user);
        rate.setDescription("Péssimo Guest");
        rate.setType(2);
        rate.setValue(1);
        rate.setCreated(new Date());
        s.save(rate);
        
        
        rate = new Rate();
        rate.setSender(user);
        rate.setReceiver(user2);
        rate.setDescription("Médio SportGuest");
        rate.setType(3);
        rate.setValue(3);
        rate.setCreated(new Date());
        s.save(rate);
        
        rate = new Rate();
        rate.setSender(user2);
        rate.setReceiver(user);
        rate.setDescription("Médio SportGuest");
        rate.setType(3);
        rate.setValue(1);
        rate.setCreated(new Date());
        s.save(rate);
        
        rate = new Rate();
        rate.setSender(user);
        rate.setReceiver(user2);
        rate.setDescription("Ótimo SportHost");
        rate.setType(4);
        rate.setValue(4);
        rate.setCreated(new Date());
        s.save(rate);
        
        rate = new Rate();
        rate.setSender(user2);
        rate.setReceiver(user);
        rate.setDescription("Ótimo SportHost");
        rate.setType(4);
        rate.setValue(3);
        rate.setCreated(new Date());
        s.save(rate);
        
        s.getTransaction().commit();
	s.close();
    }
}
