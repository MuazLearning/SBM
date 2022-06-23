package app.relations;

import domain.mtm.Kitap;
import domain.mtm.Yazar;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class MTMApp {

    public static void main(String[] args) {
        Kitap kitap = new Kitap();
        kitap.setIsim("Calikusu");

        Yazar yazar = new Yazar();
        yazar.setIsim("Resat Nuri Gultekin");

        kitap.getYazarlar().add(yazar);
        yazar.getKitaplar().add(kitap);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        kitap = (Kitap) session.merge(kitap);
        transaction.commit();

        Kitap kitap1 = session.find(Kitap.class, kitap.getId());
        Set yazarlar = kitap1.getYazarlar();

        Set<Kitap> kitapSet = new HashSet<Kitap>();
        for (Object yazar1 : yazarlar) {
            Yazar yazar2 = (Yazar) yazar1;
            System.out.println(yazar2.getIsim());
            kitapSet.addAll(yazar2.getKitaplar());
        }

        for (Kitap kitap2 : kitapSet) {
            System.out.println(kitap2.getIsim());
        }

    }
}
