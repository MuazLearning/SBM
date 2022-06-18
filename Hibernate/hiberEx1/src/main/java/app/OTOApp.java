package app;

import domain.Kisi;
import domain.ParmakIzi;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OTOApp {

    public static void main(String[] args) {

        Kisi kisi = new Kisi();
        kisi.setIsim("Muaz");

        ParmakIzi parmakIzi = new ParmakIzi();
        parmakIzi.setDosyaNo("25A");

        parmakIzi.setKisi(kisi);
        kisi.setParmakIzi(parmakIzi);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        parmakIzi = (ParmakIzi) session.merge(parmakIzi);
        transaction.commit();
    }
}
