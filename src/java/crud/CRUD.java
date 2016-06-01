/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import database.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
public class CRUD {
    
    private static SessionFactory factory;

    public CRUD(SessionFactory factory) {
        CRUD.factory = factory;
    }
    
    public List<Eventi> listEventi(Boolean tutti) {
        Session session = factory.openSession();
        ArrayList<Eventi> att = new ArrayList<Eventi>();
        att = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("tuttiEventi");
            Date d = new Date();
            query.setParameter("data", d);
            if(!tutti){
                query.setMaxResults(3);
            }
            List result = query.list();
            return result;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    
    public List<Commenti> listCommenti() {
        Session session = factory.openSession();
        ArrayList<Commenti> com = new ArrayList<Commenti>();
        com = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("tuttiCommenti");
            List result = query.list();
            return result;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    
}
