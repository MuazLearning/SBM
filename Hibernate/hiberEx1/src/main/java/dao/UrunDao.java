package dao;

import domain.Urun;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UrunDao {

    SessionFactory sessionFactory;

    public UrunDao(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Urun> findAll(){
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun").list();
        session.close();
        return list;
    }

    public Urun findById(Long id){
        Session session = sessionFactory.openSession();
//        Urun urun = (Urun) session.createQuery("from Urun where id = :id").setParameter("id", id).uniqueResult();
        Urun urun = session.get(Urun.class, id);
        session.close();
        return urun;
    }

}
