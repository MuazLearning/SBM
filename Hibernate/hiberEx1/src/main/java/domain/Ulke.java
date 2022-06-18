package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ULKE")
public class Ulke {

    @SequenceGenerator(name = "ulke", sequenceName = "ULKE_ID_SEQ")
    @Id
    @GeneratedValue(generator = "ulke", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ADI", length = 100)
    private String adi;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "ulke",
            targetEntity = Sehir.class
    )
    private Set sehirler = new HashSet();

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

    public Set getSehirler() {
        return sehirler;
    }

    public void setSehirler(Set sehirler) {
        this.sehirler = sehirler;
    }
}
