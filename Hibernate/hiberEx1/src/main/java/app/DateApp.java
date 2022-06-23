package app;

import domain.Urun;
import entityservice.UrunEntityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateApp {

    public static void main(String[] args) throws ParseException {

        UrunEntityService service = new UrunEntityService();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date sonKullanmaTarihi = format.parse("2020-12-31");

        List<Urun> urunList = service.findAllBySonKullanmaTarihi(sonKullanmaTarihi);

        for (Urun urun : urunList) {
            System.out.println(urun.getAdi() + " " + urun.getSonKullanmaTarihi());
        }

    }

}
