package app;

import dto.UrunTuruDto;
import entityservice.UrunTuruEntityService;

import java.util.List;

public class GroupByApp {

    public static void main(String[] args) {

        UrunTuruEntityService service = new UrunTuruEntityService();
        List<UrunTuruDto> urunTuruDtoList = service.findAllUrunTuruDto();

        for (UrunTuruDto urunTuruDto : urunTuruDtoList)
            System.out.println(urunTuruDto);

    }

}
