package app;

import entityservice.UrunEntityService;

public class CountApp {

    public static void main(String[] args) {

        UrunEntityService urunEntityService = new UrunEntityService();
        Long count = urunEntityService.findByUrunTuruIdCount(1L);
        System.out.println(count);

    }

}
