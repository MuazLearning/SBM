package entityservice;

import dto.UrunBilgiDto;
import dto.UrunDto;
import dao.UrunDao;
import domain.Urun;
import enums.EnumBirim;

import java.math.BigDecimal;
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

    public List<EnumBirim> findAllstokBirimi(){
        return urunDao.findAllstokBirimi();
    }

    public Double findByIdWithAvgStokMiktari(Long id){
        return urunDao.findByIdWithAvgStokMiktari(id);
    }

    public List<UrunDto> findAllUrunDto(){
        return urunDao.findAllUrunDto();
    }

    public List<UrunBilgiDto> findAllUrunBilgiDto() {
        return urunDao.findAllUrunBilgiDto();
    }

    public BigDecimal findUrunFiyatMin() {
        return urunDao.findUrunFiyatMin();
    }

    public BigDecimal findUrunFiyatMax() {
        return urunDao.findUrunFiyatMax();
    }

    public List<Urun> callUrunFindAll() {
        return urunDao.callUrunFindAll();
    }

    public List<Urun> callUrunFindUrunBetween(BigDecimal min, BigDecimal max) {
        return urunDao.callUrunFindUrunBetween(min, max);
    }

    public List<Urun> callUrunFindAll2() {
        return urunDao.callUrunFindAll2();
    }

    public List<Urun> callUrunFindUrunBetween2(BigDecimal min, BigDecimal max) {
        return urunDao.callUrunFindUrunBetween2(min, max);
    }

    public List<Urun> findAllWithCriteria() {
        return urunDao.findAllWithCriteria();
    }

}
