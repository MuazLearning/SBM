package app.criteria;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

public class OrderByApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        List<Urun> list = service.findAllWithOrderByStokMiktariCriteria();

        for (Urun urun : list)
            System.out.println(urun.getAdi() + " " + urun.getStokMiktari());

    }

}
