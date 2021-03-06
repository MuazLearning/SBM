package domain.mtm;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "KITAP")
public class Kitap {

    @SequenceGenerator(name = "kitap", sequenceName = "KITAP_ID_SEQ")
    @Id
    @GeneratedValue(generator = "kitap", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ISIM", length = 100)
    private String isim;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = Yazar.class
    )
    private Set yazarlar = new HashSet();

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

    public Set getYazarlar() {
        return yazarlar;
    }

    public void setYazarlar(Set yazarlar) {
        this.yazarlar = yazarlar;
    }
}
