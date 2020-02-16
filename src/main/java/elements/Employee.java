package elements;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "position")
    private String position;
    @Column(name = "staff_id")
    private String staffID;
    @ManyToOne
    private LocationDepartment locationDepartment;
    @ManyToOne
    private Department department;

    public Employee() {
    }

    public Employee(String name, String position, String staffID, LocationDepartment locationDepartment) {
        this.name = name;
        this.position = position;
        this.staffID = staffID;
        this.locationDepartment = locationDepartment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocationDepartment getLocationDepartment() {
        return locationDepartment;
    }

    public void setLocationDepartment(LocationDepartment locationDepartment) {
        this.locationDepartment = locationDepartment;
    }
}
