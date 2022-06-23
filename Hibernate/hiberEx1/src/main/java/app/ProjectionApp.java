package app;

import dto.UrunDto;
import entityservice.UrunEntityService;

import java.util.List;

public class ProjectionApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();
        List<UrunDto> urunDtos = service.findAllUrunDto();

        for (UrunDto urunDto : urunDtos)
            System.out.println(urunDto.toString());

    }

}
