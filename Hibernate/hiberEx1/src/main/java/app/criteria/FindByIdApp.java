package app.criteria;

import domain.Urun;
import entityservice.UrunEntityService;

public class FindByIdApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        Urun urun = service.findByIdWithCriteria(1L);

        System.out.println(urun.getAdi());

    }

}
