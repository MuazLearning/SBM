package dao;

import domain.Urun;
import dto.UrunBilgiDto;
import dto.UrunDto;
import enums.EnumBirim;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.ParameterMode;
import javax.persistence.TemporalType;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
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

    public List<Urun> findAllWithCriteria() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);
        query.from(Urun.class);

        return session.createQuery(query).getResultList();
    }

    public Urun findById(Long id) {
        Session session = sessionFactory.openSession();
//        Urun urun = (Urun) session.createQuery("from Urun where id = :id").setParameter("id", id).uniqueResult();
        Urun urun = session.get(Urun.class, id);
        session.close();
        return urun;
    }

    public Urun findByIdWithCriteria(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = query.from(Urun.class);

        query.select(root).where(criteriaBuilder.equal(root.get("id"), id));

        return session.createQuery(query).uniqueResult();
    }

    public List<Urun> findAllByStokMiktariMinAndMax(Long min, Long max) {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun where stokMiktari between :min and :max")
                .setParameter("min", min).setParameter("max", max).list();
        session.close();
        return list;
    }

    public List<Urun> findAllByStokMiktariMinAndMaxCriteria(Long min, Long max) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = query.from(Urun.class);

        query.select(root).where(criteriaBuilder.between(root.get("stokMiktari"), min, max));

        return session.createQuery(query).getResultList();
    }

    public List<Urun> findAllWithOrderByStokMiktari() {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun order by stokMiktari, adi").list();
        session.close();
        return list;
    }

    public List<Urun> findAllWithOrderByStokMiktariCriteria() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = query.from(Urun.class);

        query.select(root).orderBy(criteriaBuilder.desc(root.get("stokMiktari")), criteriaBuilder.asc(root.get("adi")));

        return session.createQuery(query).list();
    }

    public List<Urun> findAllWithOrderByStokMiktariAndLimit(int limit) {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun order by stokMiktari desc, adi asc")
                .setMaxResults(limit).list();
        session.close();
        return list;
    }

    public List<Urun> findAllWithOrderByStokMiktariAndLimitCriteria(int limit) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = query.from(Urun.class);

        query.select(root).orderBy(criteriaBuilder.desc(root.get("stokMiktari")), criteriaBuilder.asc(root.get("adi")));

        return session.createQuery(query).setMaxResults(limit).list();
    }

    public List<Urun> findAllBySonKullanmaTarihi(Date sonKullanmaTarihi) {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createQuery("from Urun where sonKullanmaTarihi >= :sonKullanmaTarihi")
                .setParameter("sonKullanmaTarihi", sonKullanmaTarihi).list();
        session.close();
        return list;
    }

    public List<Urun> findAllBySonKullanmaTarihiCriteria(Date sonKullanmaTarihi) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = query.from(Urun.class);

        ParameterExpression<Date> parameter = criteriaBuilder.parameter(Date.class);

        Predicate tarih = criteriaBuilder.greaterThanOrEqualTo(root.get("sonKullanmaTarihi").as(Date.class), parameter);

        query.where(tarih);

        return session.createQuery(query).setParameter(parameter, sonKullanmaTarihi, TemporalType.DATE).list();
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

    public BigDecimal findUrunFiyatMin() {
        Session session = sessionFactory.openSession();
        BigDecimal min = (BigDecimal) session.createQuery("select min(fiyat) from Urun").uniqueResult();
        session.close();
        return min;
    }

    public BigDecimal findUrunFiyatMax() {
        Session session = sessionFactory.openSession();
        BigDecimal max = (BigDecimal) session.createQuery("select max(fiyat) from Urun").uniqueResult();
        session.close();
        return max;
    }

    public List<Urun> callUrunFindAll() {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createNativeQuery("{call urun_findAll()}").addEntity(Urun.class).list();
        session.close();
        return list;
    }

    public List<Urun> callUrunFindUrunBetween(BigDecimal min, BigDecimal max) {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createNativeQuery("{call find_urun_between(:min, :max)}")
                .addEntity(Urun.class).setParameter("min", min).setParameter("max", max).list();
        session.close();
        return list;
    }

    public List<Urun> callUrunFindAll2() {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createStoredProcedureQuery("urun_findAll", Urun.class).getResultList();
        session.close();
        return list;
    }

    public List<Urun> callUrunFindUrunBetween2(BigDecimal min, BigDecimal max) {
        Session session = sessionFactory.openSession();
        List<Urun> list = session.createStoredProcedureQuery("find_urun_between", Urun.class)
                .registerStoredProcedureParameter("min", BigDecimal.class, ParameterMode.IN)
                .registerStoredProcedureParameter("max", BigDecimal.class, ParameterMode.IN)
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
        session.close();
        return list;
    }

}
