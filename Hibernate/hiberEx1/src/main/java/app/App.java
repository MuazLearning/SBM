package app;

import domain.UrunTuru;
import entityservice.UrunTuruEntityService;

import java.util.List;

public class App {

    public static void main(String[] args) {

        UrunTuruEntityService urunTuruEntityService = new UrunTuruEntityService();
        List<UrunTuru> urunTuruList = urunTuruEntityService.findAll();

        for (UrunTuru urunTuru : urunTuruList) {
            System.out.println(urunTuru.getAdi());
        }

    }

}
