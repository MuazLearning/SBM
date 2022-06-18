package app;

import domain.Sehir;
import domain.Ulke;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FKApp {

    public static void main(String[] args) {

        Ulke ulke = new Ulke();
        ulke.setAdi("Turkiye");

        Sehir sehir = new Sehir();
        sehir.setAdi("Istanbul");
        sehir.setUlke(ulke);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(sehir);
        transaction.commit();
    }
}
