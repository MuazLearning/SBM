package app;

import domain.mto.Sehir;
import domain.mto.Ulke;
import hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.Set;

public class OTMApp2 {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Ulke ulke = session.get(Ulke.class, 1L);

        Set sehirler = ulke.getSehirler();

        for (Object o : sehirler) {
            Sehir sehir1 = (Sehir) o;
            System.out.println(sehir1.getAdi());
        }

    }
}
