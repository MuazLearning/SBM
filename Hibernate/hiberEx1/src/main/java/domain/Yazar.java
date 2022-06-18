package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "YAZAR")
public class Yazar {

    @SequenceGenerator(name = "yazar", sequenceName = "YAZAR_ID_SEQ")
    @Id
    @GeneratedValue(generator = "yazar", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ISIM", length = 100)
    private String isim;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "yazarlar",
    )
    private Set<Kitap> kitaplar = new HashSet();

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

    public Set<Kitap> getKitaplar() {
        return kitaplar;
    }

    public void setKitaplar(Set<Kitap> kitaplar) {
        this.kitaplar = kitaplar;
    }
}
