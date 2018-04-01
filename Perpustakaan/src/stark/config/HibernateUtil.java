/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stark.config;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import stark.dao.BukuDao;
import stark.dao.BukuDaoImpl;

/**
 *
 * @author adrianfaisal
 */
public class HibernateUtil {
    
    private static final SessionFactory SESSION_FACTORY;
    private static final BukuDao BUKU_DAO;
    
    static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
            BUKU_DAO = new BukuDaoImpl(SESSION_FACTORY);
        } catch(Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." +ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
    
    public static BukuDao getBukuDao() {
        return BUKU_DAO;
    }
    
}
