package app.criteria;

import dto.UrunDto;
import entityservice.UrunEntityService;

import java.util.List;

public class ProjectionApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        List<UrunDto> urunDtoList = service.findAllUrunDtoCriteria();

        for (UrunDto urunDto : urunDtoList)
            System.out.println(urunDto);

    }

}
