package app;

import entityservice.UrunEntityService;

public class AvgApp {

    public static void main(String[] args) {
        UrunEntityService urunEntityService = new UrunEntityService();
        System.out.println(urunEntityService.findByIdWithAvgStokMiktari(1L));
    }

}
