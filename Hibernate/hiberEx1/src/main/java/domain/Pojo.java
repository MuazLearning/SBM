package domain;

import javax.persistence.*;

@Entity
@Table(name="POJO_TABLE")
public class Pojo {

    @TableGenerator(name = "table", table = "POJO_SEQ_TABLE", allocationSize = 1,
            pkColumnName = "PK_NAME", valueColumnName = "DEGER", pkColumnValue = "POJO")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
