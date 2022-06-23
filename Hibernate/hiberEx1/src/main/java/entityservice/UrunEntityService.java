package entityservice;

import dao.UrunDao;
import dao.UrunTuruDao;

public class UrunEntityService {

    private UrunDao urunDao;

    public UrunEntityService(){
        this.urunDao = new UrunDao();
    }

}
