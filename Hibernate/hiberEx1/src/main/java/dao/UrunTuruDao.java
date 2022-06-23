package dao;

import domain.UrunTuru;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UrunTuruDao{

    private SessionFactory sessionFactory;

    public UrunTuruDao(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<UrunTuru> findAll(){
        Session session = sessionFactory.openSession();
//        List<UrunTuru> list = session.createQuery("select u from UrunTuru u").list();
        List<UrunTuru> list = session.createQuery("from UrunTuru").list(); // Database'deki ismi yerine UrunTuru class ismini yazıyoruz.
        session.close();
        return list;
    }


}
