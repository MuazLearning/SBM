package app;

import domain.Urun;
import domain.UrunTuru;
import entityservice.UrunEntityService;
import entityservice.UrunTuruEntityService;

import java.util.List;

public class App {

    public static void main(String[] args) {

        urunTuruEntityService();
//        urunEntityService();

    }

    private static void urunTuruEntityService() {
        UrunTuruEntityService urunTuruEntityService = new UrunTuruEntityService();

        // findAll() methodu ile urunleri listeleyebiliriz.
//        List<UrunTuru> urunTuruList = urunTuruEntityService.findAll();
//
//        for (UrunTuru urunTuru : urunTuruList) {
//            System.out.println(urunTuru.getAdi());
//        }

        UrunTuru urunTuru = urunTuruEntityService.findById(3L);
        System.out.println(urunTuru.getAdi());
    }

    private static void urunEntityService() {

        UrunEntityService urunEntityService = new UrunEntityService();

        // findAll() methodu ile urunleri listeleyebiliriz.
/*        List<Urun> urunList = urunEntityService.findAll();

        for (Urun urun : urunList) {
            System.out.println(urun.getAdi());
        }*/

        Urun urun = urunEntityService.findById(3L);
        System.out.println(urun.getAdi());
    }

}
