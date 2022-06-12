package app;

import domain.Pojo;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.Date;

public class PojoApp {
    public static void main(String[] args) {

        Date tarih = new Date();

        Pojo pojo = new Pojo();
        pojo.setAdi("Muaz");
        pojo.setDeger(new BigDecimal("5.12"));
        pojo.setTarih(tarih);
        pojo.setSaat(tarih);
        pojo.setTarihSaat(tarih);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(pojo);
        transaction.commit();
    }
}
