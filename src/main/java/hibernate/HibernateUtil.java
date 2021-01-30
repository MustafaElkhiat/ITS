package hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    public HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    static {
        try {
            sessionFactory = (new Configuration()).configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println((new StringBuilder()).append("Initial SessionFactory creation failed.").append(ex).toString());
            throw new ExceptionInInitializerError(ex);
        }
    }
}
