package dao;

import domain.UrunTuru;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.Query;

import java.util.List;

public class UrunTuruDao {

    private SessionFactory sessionFactory;

    public UrunTuruDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<UrunTuru> findAll() {
        Session session = sessionFactory.openSession();
//        List<UrunTuru> list = session.createQuery("select u from UrunTuru u").list();
        List<UrunTuru> list = session.createQuery("from UrunTuru").list(); // Database'deki ismi yerine UrunTuru class ismini yazıyoruz.
        session.close();
        return list;
    }

    public UrunTuru findById(Long id) {
        Session session = sessionFactory.openSession();
        UrunTuru urunTuru = session.get(UrunTuru.class, id);
        session.close();
        return urunTuru;
    }

    public List<UrunTuru> findByUrunAdi(String urunAdi, MatchMode matchMode) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from UrunTuru u where u.adi like :urunAdi");

        switch (matchMode) {
            case EXACT:
                query.setParameter("urunAdi", urunAdi);
                break;
            case START:
                query.setParameter("urunAdi", urunAdi + "%");
                break;
            case END:
                query.setParameter("urunAdi", "%" + urunAdi);
                break;
            case ANYWHERE:
                query.setParameter("urunAdi", "%" + urunAdi + "%");
                break;
            default:
                break;
        }

        return query.list();
    }

}
