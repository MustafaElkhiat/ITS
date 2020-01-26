package elements;

import login.elements.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket_status")
public class TicketStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Type(type = "text")
    @Column(name = "reason")
    private String reason;
    @Type(type = "true_false")
    @Column(name = "done")
    private boolean done = false;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time = new Date();
    @Column(name = "done_date")
    @Temporal(TemporalType.DATE)
    private Date doneDate;
    @Column(name = "done_time")
    @Temporal(TemporalType.TIME)
    private Date doneTime;
    @Transient
    private String dateString;
    @Transient
    private String timeString;
    @Transient
    private String doneDateString;
    @Transient
    private String doneTimeString;
    @ManyToOne
    private Ticket ticket;
    @ManyToOne
    private Status status;
    @ManyToOne
    private User TSUser;

    public TicketStatus() {
    }

    public TicketStatus(String reason, Ticket ticket, Status status, User TSUser) {
        this.reason = reason;
        this.ticket = ticket;
        this.status = status;
        this.TSUser = TSUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getTSUser() {
        return TSUser;
    }

    public void setTSUser(User TSUser) {
        this.TSUser = TSUser;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public Date getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }

    public String getDateString() {
        return getDate().toString();
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getTimeString() {
        return getTime().toString();
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String getDoneDateString() {
        return getDoneDate().toString();
    }

    public void setDoneDateString(String doneDateString) {
        this.doneDateString = doneDateString;
    }

    public String getDoneTimeString() {
        return getDoneTime().toString();
    }

    public void setDoneTimeString(String doneTimeString) {
        this.doneTimeString = doneTimeString;
    }
}
