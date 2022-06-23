package app;

import domain.UrunTuru;
import entityservice.UrunTuruEntityService;
import org.hibernate.criterion.MatchMode;

import java.util.List;

public class LikeApp {

    public static void main(String[] args) {

        UrunTuruEntityService service = new UrunTuruEntityService();
//        List<UrunTuru> urunTurler = service.findByUrunAdi("Yiyecek", MatchMode.EXACT);
//        List<UrunTuru> urunTurler = service.findByUrunAdi("Y", MatchMode.START);
//        List<UrunTuru> urunTurler = service.findByUrunAdi("k", MatchMode.END);
        List<UrunTuru> urunTurler = service.findByUrunAdi("ecek", MatchMode.ANYWHERE);

        for (UrunTuru urunTuru : urunTurler)
            System.out.println(urunTuru.getAdi());

    }

}
