package elements;

import javax.persistence.*;

@Entity
@Table(name = "accessory")
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "accessory")
    private String accessory;


    public Accessory() {
    }

    public Accessory(String accessory) {
        this.accessory = accessory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }


}
