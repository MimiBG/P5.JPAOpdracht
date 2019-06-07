package hu.nl.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;

public class OvChipkaartDAO {
    private static SessionFactory factory;
    private Session currentSession;
    private Transaction currentTransaction;

    public OvChipkaartDAO() {
        try {
            factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private Session openSession() {
        this.currentSession = factory.openSession();
        return currentSession;
    }

    private Session openSessionWithTransaction() {
        this.currentSession = factory.openSession();
        this.currentTransaction = currentSession.beginTransaction();

        return currentSession;
    }

    public ArrayList<Reiziger> findAll() {
        openSession();
        ArrayList<Reiziger> reizigers = (ArrayList<Reiziger>) openSession().createQuery("from hu.nl.hibernate.Reiziger").list();
        currentSession.close();

        return reizigers;
    }

    public void createkaart(OvChipkaart kaart) {
        try {
            openSessionWithTransaction();
            openSession().save(kaart);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            currentTransaction.commit();
            currentSession.close();
        }
    }

    public void updateKaart(OvChipkaart kaart) {
        try {
            openSessionWithTransaction();
            openSession().update(kaart);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            currentTransaction.commit();
            currentSession.close();
        }
    }

    public void deleteKaart(OvChipkaart kaart) {
        try {
            openSessionWithTransaction();
            openSession().delete(kaart);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            currentTransaction.commit();
            currentSession.close();
        }
    }

    public void getKaart(int id) {
        try {
            openSessionWithTransaction();
            openSession().get(OvChipkaart.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            currentTransaction.commit();
            currentSession.close();
        }
    }
}