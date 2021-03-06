package domain.oto;

import javax.persistence.*;

@Entity
@Table(name = "KISI")
public class Kisi {

    @SequenceGenerator(name = "kisi", sequenceName = "KISI_ID_SEC")
    @Id
    @GeneratedValue(generator = "kisi", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ISIM", length = 100)
    private String isim;

    // mappedBy => Kullanıldığı entity için database de veri oluşmamasını sağlıyor. Kisi tablosunda "parmakizi" kolonu oluşmaz
    // mappedBy için parkIzındeki kisi değişkeninin adı birebir aynı yazılır.
    // TODO optional false yap. Hatayı çöz
    @OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "kisi")
    private ParmakIzi parmakIzi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public ParmakIzi getParmakIzi() {
        return parmakIzi;
    }

    public void setParmakIzi(ParmakIzi parmakIzi) {
        this.parmakIzi = parmakIzi;
    }
}
