package app.storeprosedure;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

public class CallSPWithParametersApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        List<Urun> list = service.callUrunFindUrunBetween(10L, 20L);

        for (Urun urun : list)
            System.out.println(urun.getAdi() + " - " + urun.getFiyat());

    }

}
