package helpers;


import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;


public class HibernateHelper extends HelperBase {


    public HibernateHelper(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public List retreiveData(String query) {
        List dataList;
        Session session = openSession();
        dataList = session.createQuery(query).getResultList();
        closeSession(session);

        return dataList;
    }

    public Object retreiveData(Class classBean, Serializable id) {
        Object data;
        Session session = openSession();
        data = session.get(classBean, id);
        closeSession(session);

        return data;
    }

    public void updateData(Object object)
            throws IOException {
        Session session = openSession();
        session.update(object);
        closeSession(session);


    }

    public void saveData(Object object)
            throws IOException {
        Session session = openSession();
        session.save(object);
        closeSession(session);


    }

    public void saveData(List objectList)
            throws IOException {
        Session session = openSession();
        for (Object object : objectList) {
            session.save(object);
        }

        closeSession(session);


    }

    public void deleteData(Object object)
            throws IOException {
        Session session = openSession();
        session.delete(object);
        closeSession(session);
    }

    public void successMessage(String message)
            throws IOException {
        response.setStatus(200);
        response.getWriter().print(message);
    }

    public void errorMessage(String message)
            throws IOException {
        response.setStatus(500);
        response.getWriter().print(message);
    }

    private Session openSession() {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        return session;
    }

    private void closeSession(Session session) {
        session.getTransaction().commit();

        if (session != null) {
            session.close();
            System.out.println("session closed");
        }
    }
}
