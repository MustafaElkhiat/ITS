package elements;

import login.elements.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Type(type = "true_false")
    @Column(name = "done")
    private boolean done = false;
    @Type(type = "text")
    @Column(name = "problem")
    private String problem;
    @Type(type = "text")
    @Column(name = "comment")
    private String comment;
    @Column(name = "reporter_name")
    private String reporterName;
    @Column(name = "reporter_num")
    private String reporterNum;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate = new Date();
    @Temporal(TemporalType.TIME)
    @Column(name = "start_time")
    private Date startTime = new Date();
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    @Temporal(TemporalType.TIME)
    @Column(name = "end_time")
    private Date endTime;
    @Temporal(TemporalType.DATE)
    @Column(name = "actual_date")
    private Date actualDate;
    @Temporal(TemporalType.TIME)
    @Column(name = "actual_time")
    private Date actualTime;
    @ManyToOne
    private Device device;
    @ManyToOne
    private User l1_user;
    @ManyToOne
    private User solvedBy;
    @ManyToOne
    private User closedBy;
    @ManyToOne
    private SubCategory subCategory;
    @ManyToOne
    private Status currentStatus;

    public Ticket() {
    }

    public Ticket(String problem, String comment, String reporterName, String reporterNum, Device device, User l1_user, SubCategory subCategory, Status currentStatus, Date actualDate, Date actualTime) {
        this.problem = problem;
        this.comment = comment;
        this.reporterName = reporterName;
        this.reporterNum = reporterNum;
        this.device = device;
        this.l1_user = l1_user;
        this.subCategory = subCategory;
        this.currentStatus = currentStatus;
        this.actualDate = actualDate;
        this.actualTime = actualTime;
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

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public User getL1_user() {
        return l1_user;
    }

    public void setL1_user(User l1_user) {
        this.l1_user = l1_user;
    }

    public User getSolvedBy() {
        return solvedBy;
    }

    public void setSolvedBy(User solvedBy) {
        this.solvedBy = solvedBy;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getReporterNum() {
        return reporterNum;
    }

    public void setReporterNum(String reporterNum) {
        this.reporterNum = reporterNum;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public Date getActualTime() {
        return actualTime;
    }

    public void setActualTime(Date actualTime) {
        this.actualTime = actualTime;
    }

    public User getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(User closedBy) {
        this.closedBy = closedBy;
    }
}
