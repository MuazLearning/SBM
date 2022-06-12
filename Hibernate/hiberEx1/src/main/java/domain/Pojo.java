package domain;

import javax.persistence.*;
import java.math.BigDecimal;

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
}
