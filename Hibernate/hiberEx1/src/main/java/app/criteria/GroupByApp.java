package app.criteria;

import dto.UrunTuruDto;
import entityservice.UrunTuruEntityService;

import java.util.List;

public class GroupByApp {

    public static void main(String[] args) {

        UrunTuruEntityService service = new UrunTuruEntityService();
        List<UrunTuruDto> urunTuruDtoList = service.findAllUrunTuruDtoCriteria();

        for (UrunTuruDto urunTuruDto : urunTuruDtoList)
            System.out.println(urunTuruDto);

    }

}
