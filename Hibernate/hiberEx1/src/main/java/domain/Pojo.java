package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "POJO_TABLE")
public class Pojo {

    @TableGenerator(name = "table", table = "POJO_SEQ_TABLE", allocationSize = 1,
            pkColumnName = "PK_NAME", valueColumnName = "DEGER", pkColumnValue = "POJO")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table")
    @Column(name = "ID")
    private Long id;

    @Column(name = "ADI", length = 100, nullable = false) // insertable = false, updatable = false
    private String adi;

    @Column(name = "DEGER", precision = 15, scale = 2)
    private BigDecimal deger;

    @Column(name = "TARIH")
    @Temporal(TemporalType.DATE)
    private Date tarih;

    @Column(name = "SAAT")
    @Temporal(TemporalType.TIME)
    private Date saat;

    @Column(name = "TARIH_SAAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tarihSaat;

    @Transient
    private String geciciGrup;

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

    public BigDecimal getDeger() {
        return deger;
    }

    public void setDeger(BigDecimal deger) {
        this.deger = deger;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public Date getSaat() {
        return saat;
    }

    public void setSaat(Date saat) {
        this.saat = saat;
    }

    public Date getTarihSaat() {
        return tarihSaat;
    }

    public void setTarihSaat(Date tarihSaat) {
        this.tarihSaat = tarihSaat;
    }

    public String getGeciciGrup() {
        return geciciGrup;
    }

    public void setGeciciGrup(String geciciGrup) {
        this.geciciGrup = geciciGrup;
    }

}
