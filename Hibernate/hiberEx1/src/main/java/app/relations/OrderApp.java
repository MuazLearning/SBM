package app.relations;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

public class OrderApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        List<Urun> urunler = service.findAllWithOrderByStokMiktari();

        for (Urun urun : urunler) {
//            System.out.println(urun.getAdi() + "\t" + urun.getStokMiktari());
            System.out.format("%10s %10d\n", urun.getAdi(), urun.getStokMiktari());
        }

    }

}
