package app;

import domain.Sehir;
import domain.Ulke;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OTMApp {

    public static void main(String[] args) {

        Ulke ulke = new Ulke();
        ulke.setAdi("Turkiye");

        Sehir sehir = new Sehir();
        sehir.setAdi("Istanbul");
        sehir.setUlke(ulke);

        Sehir sehir1 = new Sehir();
        sehir1.setAdi("Ordu");
        sehir1.setUlke(ulke);

        ulke.getSehirler().add(sehir);
        ulke.getSehirler().add(sehir1);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(ulke);
        transaction.commit();
    }
}
