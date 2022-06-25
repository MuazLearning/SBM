package app.criteria;

import entityservice.UrunEntityService;

public class AvgApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        System.out.println(service.findByAvgStokMiktariCriteria());

    }

}
