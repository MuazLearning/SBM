package app.criteria;

import entityservice.UrunEntityService;

import java.math.BigDecimal;

public class MinMaxApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        BigDecimal min = service.findUrunFiyatMinCriteria();
        BigDecimal max = service.findUrunFiyatMaxCriteria();

        System.out.println(min);
        System.out.println(max);
    }

}
