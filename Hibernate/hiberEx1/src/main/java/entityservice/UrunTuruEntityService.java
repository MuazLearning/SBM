package entityservice;

import dao.UrunTuruDao;
import domain.UrunTuru;

import java.util.List;

public class UrunTuruEntityService {

    private UrunTuruDao urunTuruDao;

    public UrunTuruEntityService(){
        this.urunTuruDao = new UrunTuruDao();
    }

    public List<UrunTuru> findAll(){
        return urunTuruDao.findAll();
    }

}
