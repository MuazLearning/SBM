package domain;

import javax.persistence.*;

@Entity
@Table(name = "SEHIR")
public class Sehir {

    @SequenceGenerator(name = "sehir", sequenceName = "SEHIR_ID_SEQ")
    @Id
    @GeneratedValue(generator = "sehir", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ADI", length = 100)
    private String adi;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "ID_ULKE",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_SEHIR_ULKE", value = ConstraintMode.CONSTRAINT,
//                    foreignKeyDefinition = "UNIQUE(ID)"
                    foreignKeyDefinition = "FOREIGN KEY(ID_ULKE) REFERENCES ULKE(ID) ON DELETE CASCADE"
            )
    )
    private Ulke ulke;

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

    public Ulke getUlke() {
        return ulke;
    }

    public void setUlke(Ulke ulke) {
        this.ulke = ulke;
    }
}
