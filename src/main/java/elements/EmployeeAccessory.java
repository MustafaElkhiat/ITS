package elements;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "employee_accessory")
public class EmployeeAccessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "valid")
    @Type(type = "true_false")
    private boolean valid = false;
    @ManyToOne
    private Accessory accessory;
    @ManyToOne
    private Employee employee;

    public EmployeeAccessory() {
    }

    public EmployeeAccessory(Accessory accessory, Employee employee) {
        this.accessory = accessory;
        this.employee = employee;
    }

    public EmployeeAccessory(String vendor, String serialNumber, String phoneNumber, Accessory accessory, Employee employee) {
        this.vendor = vendor;
        this.serialNumber = serialNumber;
        this.phoneNumber = phoneNumber;
        this.accessory = accessory;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
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
