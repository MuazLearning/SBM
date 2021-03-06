package domain;

import enums.EnumUrunTuru;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "URUN_TURU")
public class UrunTuru {

    @Id
    @GeneratedValue(generator = "urunturu", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "urunturu", sequenceName = "URUN_TURU_ID_SEQ")
    private Long id;

    @Column(name = "ADI", length = 100)
    private String adi;

    @Enumerated(EnumType.STRING)
    @Column(name = "TUR", length = 30)
    private EnumUrunTuru urunTuru;

    @OneToMany(targetEntity = Urun.class, mappedBy = "urunTuru", fetch = FetchType.LAZY)
    private Set urunler = new HashSet();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public EnumUrunTuru getUrunTuru() {
        return urunTuru;
    }

    public void setUrunTuru(EnumUrunTuru urunTuru) {
        this.urunTuru = urunTuru;
    }

    public Set getUrunler() {
        return urunler;
    }

    public void setUrunler(Set urunler) {
        this.urunler = urunler;
    }
}
