package hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory; //MySQL session
    private static final SessionFactory sqlServerSessionFactory; //SQLServer session

    public HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static SessionFactory getSQLServerSessionFactory() {
        return sqlServerSessionFactory;
    }

    static {
        try {
            sessionFactory = (new Configuration()).configure("hibernate.cfg.xml").buildSessionFactory();
            sqlServerSessionFactory = (new Configuration()).configure("sqlserver.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println((new StringBuilder()).append("Initial SessionFactory creation failed.").append(ex).toString());
            throw new ExceptionInInitializerError(ex);
        }
    }
}
