package entityservice;

import dao.UrunDao;

public class UrunEntityService {

    private UrunDao urunDao;

    public UrunEntityService(){
        this.urunDao = new UrunDao();
    }

}
