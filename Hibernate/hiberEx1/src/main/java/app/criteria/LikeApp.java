package app.criteria;

import domain.UrunTuru;
import entityservice.UrunTuruEntityService;
import org.hibernate.criterion.MatchMode;

import java.util.List;

public class LikeApp {

    public static void main(String[] args) {

        UrunTuruEntityService service = new UrunTuruEntityService();

        List<UrunTuru> urunTurler = service.findByUrunAdiCriteria("Yiyecek", MatchMode.EXACT);
//        List<UrunTuru> urunTurler = service.findByUrunAdiCriteria("Y", MatchMode.START);
//        List<UrunTuru> urunTurler = service.findByUrunAdiCriteria("k", MatchMode.END);
//        List<UrunTuru> urunTurler = service.findByUrunAdiCriteria("ecek", MatchMode.ANYWHERE);

        for (UrunTuru urunTuru : urunTurler)
            System.out.println(urunTuru.getAdi());

    }

}
