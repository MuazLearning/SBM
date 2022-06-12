package domain;

import javax.persistence.*;

@Entity
@Table(name="POJO_TABLE")
public class Pojo {

    // allocationSize = artış miktarı, initialValue = başlangıç
    @SequenceGenerator(name="seq", sequenceName = "POJO_TABLE_ID_SEQ", allocationSize = 1, initialValue = 100)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
