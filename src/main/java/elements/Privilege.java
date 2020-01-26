package elements;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "privilege")
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name="privilege")
    private String privilege ;
    @OneToMany(mappedBy = "privilege")
    private List<UserPrivilege> userPrivilegeList = new ArrayList<>();

    public Privilege() {
    }

    public Privilege(String privilege) {
        this.privilege = privilege;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}
