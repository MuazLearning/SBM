package domain;

import javax.persistence.*;

@Entity
@Table(name = "PARMAK_IZI")
public class ParmakIzi {

    @SequenceGenerator(name = "parmak", sequenceName = "PARMAK_IZI_ID_SEC")
    @Id
    @GeneratedValue(generator = "parmak", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DOSYA_NO", length = 10)
    private String dosyaNo;

    // optinal => Aradaki ilişki zorunlu mu?
    // orphanRemoval => kullanıldıktan sonra silinsin mi?
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, optional = false)
    private Kisi kisi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDosyaNo() {
        return dosyaNo;
    }

    public void setDosyaNo(String dosyaNo) {
        this.dosyaNo = dosyaNo;
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }
}
