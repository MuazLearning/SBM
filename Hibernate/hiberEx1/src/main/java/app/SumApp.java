package app;

import entityservice.UrunEntityService;

public class SumApp {

    public static void main(String[] args) {

        UrunEntityService urunEntityService = new UrunEntityService();
        Long sum = urunEntityService.findByUrunTuruIdAndSumStokMiktari(1L);
        System.out.println(sum); 

    }

}
