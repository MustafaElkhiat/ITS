package elements;

import login.elements.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket_assigned_to")
public class TicketAssignedTo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Type(type = "true_false")
    @Column(name = "done")
    private boolean done = false;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date = new Date();
    @Temporal(TemporalType.TIME)
    @Column(name = "time")
    private Date time = new Date();
    @ManyToOne
    private Ticket ticket;
    @ManyToOne
    private User assignedTo;
    @ManyToOne
    private User assignedBy;

    public TicketAssignedTo() {
    }

    public TicketAssignedTo(Ticket ticket, User assignedTo, User assignedBy) {
        this.ticket = ticket;
        this.assignedTo = assignedTo;
        this.assignedBy = assignedBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public User getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(User assignedBy) {
        this.assignedBy = assignedBy;
    }
}
