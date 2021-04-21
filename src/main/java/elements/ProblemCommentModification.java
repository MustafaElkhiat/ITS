package elements;

import login.elements.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "problem_comment_modification")
public class ProblemCommentModification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "problem")
    private String problem;
    @Column(name = "comment")
    private String comment;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time = new Date();
    @Type(type = "true_false")
    @Column(name = "edited")
    private boolean edited = false;
    @ManyToOne
    private SubCategory subCategory;
    @ManyToOne
    private User user;
    @ManyToOne
    private Ticket ticket;

    public ProblemCommentModification() {
    }

    public ProblemCommentModification(String problem, String comment, SubCategory subCategory, User user, Ticket ticket) {
        this.problem = problem;
        this.comment = comment;
        this.subCategory = subCategory;
        this.user = user;
        this.ticket = ticket;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }
}
