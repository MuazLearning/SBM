package entityservice;

import dao.UrunTuruDao;
import domain.Urun;
import domain.UrunTuru;
import dto.UrunTuruDto;
import org.hibernate.criterion.MatchMode;

import java.util.List;

public class UrunTuruEntityService {

    private UrunTuruDao urunTuruDao;

    public UrunTuruEntityService(){
        this.urunTuruDao = new UrunTuruDao();
    }

    public List<UrunTuru> findAll(){
        return urunTuruDao.findAll();
    }

    public UrunTuru findById(Long id){
        return urunTuruDao.findById(id);
    }

    public List<UrunTuru> findByUrunAdi(String urunAdi, MatchMode matchMode) {
        return urunTuruDao.findByUrunAdi(urunAdi, matchMode);
    }

    public List<UrunTuruDto> findAllUrunTuruDto(){
        return urunTuruDao.findAllUrunTuruDto();
    }

    public List<UrunTuru> findByUrunAdiCriteria(String adi, MatchMode matchMode) {
        return urunTuruDao.findByUrunAdiCriteria(adi, matchMode);
    }

    public List<UrunTuruDto> findAllUrunTuruDtoCriteria() {
        return urunTuruDao.findAllUrunTuruDtoCriteria();
    }

}
