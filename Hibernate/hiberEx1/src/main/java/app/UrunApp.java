package app;

import domain.Urun;
import domain.UrunTuru;
import enums.EnumUrunTuru;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UrunApp {
    public static void main(String[] args) {

        Urun urun = new Urun();
//        urun.setAdi("Bilgisayar");

        UrunTuru urunTuru = new UrunTuru();
        urunTuru.setAdi("Yiyecek");
        urunTuru.setUrunTuru(EnumUrunTuru.YIYECEK);

        urun.setUrunTuru(urunTuru);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        urunTuru =(UrunTuru) session.merge(urunTuru);
        transaction.commit();
    }

    }
