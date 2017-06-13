package DAO;

import java.util.List;
import org.hibernate.Session;

public class LoginDAO {

    public static boolean validate(String username, String password) {
        Session session = HibernateSessionFactory.getSession(); 
        session.beginTransaction();
        List user = session.createSQLQuery("SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?")
                .setString(0, username)
                .setString(1, password).list();
        session.close();
        return (user.size() > 0);
    }
}
