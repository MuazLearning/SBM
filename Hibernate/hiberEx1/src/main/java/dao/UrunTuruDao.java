package dao;

import domain.Urun;
import domain.UrunTuru;
import dto.UrunTuruDto;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
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

        List<UrunTuru> list = query.list();

        session.close();

        return list;
    }

    public List<UrunTuru> findByUrunAdiCriteria(String adi, MatchMode matchMode) {

        String parameter = "";

        switch (matchMode) {
            case EXACT:
                parameter = adi;
                break;
            case START:
                parameter = adi + "%";
                break;
            case END:
                parameter = "%" + adi;
                break;
            case ANYWHERE:
                parameter = "%" + adi + "%";
                break;
            default:
                break;
        }


        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UrunTuru> query = criteriaBuilder.createQuery(UrunTuru.class);
        Root<UrunTuru> root = query.from(UrunTuru.class);

        query.select(root).where(criteriaBuilder.like(root.<String>get("adi"), parameter));

        return session.createQuery(query).list();
    }

    public List<UrunTuruDto> findAllUrunTuruDto() {
        Session session = sessionFactory.openSession();
        List<UrunTuruDto> list = session.createQuery("select new dto.UrunTuruDto (" +
                "urunTuru.id, urunTuru.adi, min (urun.fiyat), max (urun.fiyat), " +
                "avg (urun.fiyat), sum  (urun.stokMiktari), count (urun.id)) " +
                "from Urun urun, UrunTuru urunTuru " +
                "where urun.urunTuru.id = urunTuru.id " +
                "group by urunTuru.id, urunTuru.adi").list();
        session.close();
        return list;
    }

    public List<UrunTuruDto> findAllUrunTuruDtoCriteria() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UrunTuruDto> query = criteriaBuilder.createQuery(UrunTuruDto.class);
        Root<Urun> root = query.from(Urun.class);

        root.join("urunTuru", JoinType.INNER);
        query.groupBy(root.get("urunTuru").get("id"));
        query.select(criteriaBuilder.construct(UrunTuruDto.class,
                root.get("urunTuru").get("id"),
                root.get("urunTuru").get("adi"),
                criteriaBuilder.min(root.get("fiyat")),
                criteriaBuilder.max(root.get("fiyat")),
                criteriaBuilder.avg(root.get("fiyat")),
                criteriaBuilder.sum(root.get("stokMiktari")),
                criteriaBuilder.count(root.get("id"))
        ));

        return session.createQuery(query).list();
    }

}
