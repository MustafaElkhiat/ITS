package elements;

import javax.persistence.*;

@Entity
@Table(name = "pc_type")
public class PCType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name="pc_type")
    private String pcType;

    public PCType() {
    }

    public PCType(String pcType) {
        this.pcType = pcType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPcType() {
        return pcType;
    }

    public void setPcType(String pcType) {
        this.pcType = pcType;
    }
}
