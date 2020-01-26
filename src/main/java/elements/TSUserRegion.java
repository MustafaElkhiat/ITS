package elements;

import login.elements.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "ts_user_region")
public class TSUserRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "edited")
    @Type(type = "true_false")
    private boolean edited = false;
    @ManyToOne
    private User TSUser ;
    @ManyToOne
    private Region region;

    public TSUserRegion() {
    }

    public TSUserRegion(User TSUser, Region region) {
        this.TSUser = TSUser;
        this.region = region;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getTSUser() {
        return TSUser;
    }

    public void setTSUser(User TSUser) {
        this.TSUser = TSUser;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }
}
