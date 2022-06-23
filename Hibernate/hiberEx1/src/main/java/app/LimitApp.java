package app;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

public class LimitApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        List<Urun> urunler = service.findAllWithOrderByStokMiktariAndLimit(5);

        System.out.printf("\n%-20s %10s\n", "Urun Adi", "Stok Miktari");

        for (Urun urun : urunler)
            System.out.printf("%-20s %10d\n", urun.getAdi(), urun.getStokMiktari());

    }

}
