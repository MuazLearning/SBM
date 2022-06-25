package app.criteria;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

public class BetweenApp {

    public static void main(String[] args) {
        UrunEntityService urunEntityService = new UrunEntityService();
        List<Urun> urunList = urunEntityService.findAllByStokMiktariMinAndMaxCriteria(100L, 500L);

        for (Urun urun : urunList)
            System.out.println(urun.getAdi() + " " + urun.getStokMiktari());

    }

}
