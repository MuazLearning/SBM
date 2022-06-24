package app.criteria;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

public class FindAllApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        List<Urun> list = service.findAllWithCriteria();

        for (Urun urun : list) {
            System.out.println(urun.getAdi());
        }

    }

}
