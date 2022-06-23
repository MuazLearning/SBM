package dao;

import domain.Urun;
import dto.UrunBilgiDto;
import dto.UrunDto;
import enums.EnumBirim;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class UrunDao {

    SessionFactory sessionFactory;

    public UrunDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Urun> findAll() {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun").list();
        session.close();
        return list;
    }

    public Urun findById(Long id) {
        Session session = sessionFactory.openSession();
//        Urun urun = (Urun) session.createQuery("from Urun where id = :id").setParameter("id", id).uniqueResult();
        Urun urun = session.get(Urun.class, id);
        session.close();
        return urun;
    }

    public List<Urun> findAllByStokMiktariMinAndMax(Long min, Long max) {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun where stokMiktari between :min and :max")
                .setParameter("min", min).setParameter("max", max).list();
        session.close();
        return list;
    }

    public List<Urun> findAllWithOrderByStokMiktari() {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun order by stokMiktari, adi").list();
        session.close();
        return list;
    }

    public List<Urun> findAllWithOrderByStokMiktariAndLimit(int limit) {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun order by stokMiktari desc, adi asc")
                .setMaxResults(limit).list();
        session.close();
        return list;
    }

    public List<Urun> findAllBySonKullanmaTarihi(Date sonKullanmaTarihi) {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun where sonKullanmaTarihi >= :sonKullanmaTarihi")
                .setParameter("sonKullanmaTarihi", sonKullanmaTarihi).list();
        session.close();
        return list;
    }

    public Long findByUrunTuruIdAndSumStokMiktari(Long id) {
        Session session = sessionFactory.openSession();
        Long sum = (Long) session.createQuery("select sum(stokMiktari) from Urun where urunTuru.id = :id")
                .setParameter("id", id).uniqueResult();
        session.close();
        return sum;
    }

    public Long findByUrunTuruIdCount(Long id) {
        Session session = sessionFactory.openSession();
        Long count = (Long) session.createQuery("select count(*) from Urun where urunTuru.id = :id")
                .setParameter("id", id).uniqueResult();
        session.close();
        return count;
    }

    public List<EnumBirim> findAllstokBirimi() {
        Session session = sessionFactory.openSession();
        List<EnumBirim> list = session.createQuery("select distinct stokBirimi from Urun").list();
        session.close();
        return list;
    }

    public Double findByIdWithAvgStokMiktari(Long id) {
        Session session = sessionFactory.openSession();
        Double avg = (Double) session.createQuery("select avg(stokMiktari) from Urun where urunTuru.id = :id")
                .setParameter("id", id).uniqueResult();
        session.close();
        return avg;
    }

    public List<UrunDto> findAllUrunDto() {
        Session session = sessionFactory.openSession();
        List<UrunDto> list = session.createQuery("select new dto.UrunDto(id, adi, fiyat) from Urun u").list();
        session.close();
        return list;
    }

    public List<UrunBilgiDto> findAllUrunBilgiDto() {
        Session session = sessionFactory.openSession();
        List<UrunBilgiDto> list = session.createQuery("select " +
                "new dto.UrunBilgiDto(u.id, u.adi, u.fiyat, ut.adi, ut.urunTuru)" +
                " from Urun u, UrunTuru ut " +
                "where u.urunTuru.id = ut.id").list();
        session.close();
        return list;
    }


}
