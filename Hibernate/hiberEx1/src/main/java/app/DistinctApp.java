package app;

import entityservice.UrunEntityService;
import enums.EnumBirim;

import java.util.List;

public class DistinctApp {

    public static void main(String[] args) {

        UrunEntityService urunEntityService = new UrunEntityService();
        List<EnumBirim> birimler = urunEntityService.findAllstokBirimi();

        for (EnumBirim birim : birimler)
            System.out.println(birim.getBirim());
    }

}
