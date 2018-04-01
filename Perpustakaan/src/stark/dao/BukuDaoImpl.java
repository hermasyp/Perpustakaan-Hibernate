/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stark.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import stark.model.Buku;

/**
 *
 * @author yuda14305
 */
public class BukuDaoImpl implements BukuDao{
    private final SessionFactory sessionFactory;
    
    public BukuDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveBuku(Buku buku) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(buku);
            session.getTransaction().commit();    
        } catch (Exception exception) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Buku> getDaftarBuku() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<Buku> daftarBuku = session.createCriteria(Buku.class).list();
            session.getTransaction().commit();
            return daftarBuku;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }finally{
            session.close();
        }
    }
    
}


