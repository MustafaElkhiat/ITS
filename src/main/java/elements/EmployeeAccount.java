package elements;

import org.hibernate.annotations.Type;

import javax.persistence.*;
@Entity
@Table(name = "employee_account")
public class EmployeeAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "valid")
    @Type(type = "true_false")
    private boolean valid = false;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Employee employee;

    public EmployeeAccount() {
    }

    public EmployeeAccount(Account account, Employee employee) {
        this.account = account;
        this.employee = employee;
    }

    public EmployeeAccount(String username, Account account, Employee employee) {
        this.username = username;
        this.account = account;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
