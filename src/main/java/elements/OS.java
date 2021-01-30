package elements;

import javax.persistence.*;

@Entity
@Table(name = "os")
public class OS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name="os")
    private String OS;

    public OS() {
    }

    public OS(String OS) {
        this.OS = OS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }
}
