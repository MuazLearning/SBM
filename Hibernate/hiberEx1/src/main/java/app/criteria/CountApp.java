package app.criteria;

import entityservice.UrunEntityService;

public class CountApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        Long count = service.findByUrunTuruCountCriteria(1L);

        System.out.println(count);
    }

}
