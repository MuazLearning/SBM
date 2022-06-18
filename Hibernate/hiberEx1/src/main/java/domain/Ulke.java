package domain;

import javax.persistence.*;

@Entity
@Table(name = "ULKE")
public class Ulke {

    @SequenceGenerator(name = "ulke", sequenceName = "ULKE_ID_SEQ")
    @Id
    @GeneratedValue(generator = "ulke", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ADI", length = 100)
    private String adi;

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
}
