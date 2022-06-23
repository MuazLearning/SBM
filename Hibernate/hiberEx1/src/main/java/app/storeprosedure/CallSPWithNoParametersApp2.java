package app.storeprosedure;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

public class CallSPWithNoParametersApp2 {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        List<Urun> list = service.callUrunFindAll2();

        for (Urun urun : list) {
            System.out.println(urun.getAdi());
        }

    }

}
