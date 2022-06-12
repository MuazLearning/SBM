package app;

import domain.Pojo;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class PojoApp {
    public static void main(String[] args) {
        Pojo pojo = new Pojo();
        pojo.setAdi("Muaz");
        pojo.setDeger(new BigDecimal("5.12"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(pojo);
        transaction.commit();
    }
}
