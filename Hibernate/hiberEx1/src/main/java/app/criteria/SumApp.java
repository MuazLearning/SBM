package app.criteria;

import entityservice.UrunEntityService;

public class SumApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        Long sum = service.findByUrunTuruIdAndSumStokMiktariCriteria();

        System.out.println(sum);

    }

}
