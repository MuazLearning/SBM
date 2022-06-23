package app;

import entityservice.UrunEntityService;

public class MinMaxApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        System.out.println(service.findUrunFiyatMin());

        System.out.println(service.findUrunFiyatMax());
    }

}
