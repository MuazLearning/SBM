package entityservice;

import dao.UrunDao;
import domain.Urun;

import java.util.Date;
import java.util.List;

public class UrunEntityService {

    private UrunDao urunDao;

    public UrunEntityService() {
        this.urunDao = new UrunDao();
    }

    public List<Urun> findAll() {
        return urunDao.findAll();
    }

    public Urun findById(Long id) {
        return urunDao.findById(id);
    }

    public List<Urun> findAllByStokMiktariMinAndMax(Long min, Long max) {
        return urunDao.findAllByStokMiktariMinAndMax(min, max);
    }

    public List<Urun> findAllWithOrderByStokMiktari() {
        return urunDao.findAllWithOrderByStokMiktari();
    }

    public List<Urun> findAllWithOrderByStokMiktariAndLimit(int limit) {
        return urunDao.findAllWithOrderByStokMiktariAndLimit(limit);
    }

    public List<Urun> findAllBySonKullanmaTarihi(Date sonKullanmaTarihi) {
        return urunDao.findAllBySonKullanmaTarihi(sonKullanmaTarihi);
    }

    public Long findByUrunTuruIdAndSumStokMiktari(Long id){
        return urunDao.findByUrunTuruIdAndSumStokMiktari(id);
    }

    public Long findByUrunTuruIdCount(Long id){
        return urunDao.findByUrunTuruIdCount(id);
    }

}
