package app.storeprosedure;

import domain.Urun;
import entityservice.UrunEntityService;

import java.math.BigDecimal;
import java.util.List;

public class CallSPWithParametersApp2 {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        List<Urun> list = service.callUrunFindUrunBetween2(new BigDecimal(10), new BigDecimal(20));

        for (Urun urun : list)
            System.out.println(urun.getAdi() + " - " + urun.getFiyat());

    }

}
