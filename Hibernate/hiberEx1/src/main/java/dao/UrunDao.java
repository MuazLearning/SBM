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

    public List<Urun> findAllByStokMiktariMinAndMax(Long min, Long max){
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun where stokMiktari between :min and :max")
                .setParameter("min", min).setParameter("max", max).list();
        session.close();
        return list;
    }

    public List<Urun> findAllWithOrderByStokMiktari(){
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun order by stokMiktari, adi").list();
        session.close();
        return list;
    }

    public List<Urun> findAllWithOrderByStokMiktariAndLimit(int limit){
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun order by stokMiktari desc, adi asc")
                .setMaxResults(limit).list();
        session.close();
        return list;
    }

}
