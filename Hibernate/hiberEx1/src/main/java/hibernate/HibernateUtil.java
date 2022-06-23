package hibernate;

import domain.Urun;
import domain.UrunTuru;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration cfg = new Configuration();
//            cfg.addAnnotatedClass(Pojo.class);
//
//            cfg.addAnnotatedClass(Kisi.class);
//            cfg.addAnnotatedClass(ParmakIzi.class);
//
//            cfg.addAnnotatedClass(Kitap.class);
//            cfg.addAnnotatedClass(Yazar.class);

//            cfg.addAnnotatedClass(Ulke.class);
//            cfg.addAnnotatedClass(Sehir.class);

            cfg.addAnnotatedClass(UrunTuru.class);
            cfg.addAnnotatedClass(Urun.class);

            SessionFactory sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();

            return sessionFactory;
        } catch (Exception e) {
            System.out.println("Session factory oluşturulurken bir hata oluştu." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
