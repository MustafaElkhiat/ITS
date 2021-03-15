package elements;

import login.elements.User;

import javax.persistence.*;

@Entity
@Table(name = "ts_user_category")
public class TSUserCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    private User TSUser ;
    @ManyToOne
    private Category category;

    public TSUserCategory() {
    }

    public TSUserCategory(User TSUser, Category category) {
        this.TSUser = TSUser;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
