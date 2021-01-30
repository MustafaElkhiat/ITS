package elements;

import javax.persistence.*;

@Entity
@Table(name = "location_department", uniqueConstraints = {@UniqueConstraint(columnNames = {"location_id", "department_id"})})
public class LocationDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    private Location location;
    @ManyToOne
    private Department department;

    public LocationDepartment() {
    }

    public LocationDepartment(Location location, Department department) {
        this.location = location;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
