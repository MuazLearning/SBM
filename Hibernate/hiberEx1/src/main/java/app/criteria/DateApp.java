package app.criteria;

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
        Date tarih = format.parse("2022-01-01");
//        List<Urun> urunList = service.findAllBySonKullanmaTarihiCriteria(tarih);

        List<Urun> urunList = service.findAllBySonKullanmaTarihiCriteria(new Date());

        for (Urun urun : urunList)
            System.out.println(urun.getAdi() + " " + urun.getSonKullanmaTarihi());

    }

}
