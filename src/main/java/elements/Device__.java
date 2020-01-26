package elements;

import javax.persistence.*;

@Entity
@Table(name = "device")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue(value = "device")
public class Device__ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "device")
    private String device;
    @Column(name = "any_desk_id")
    private String any_desk_id;
    @Column(name = "mac_address")
    private String mac_address;
    @Column(name = "ip_address")
    private String ip_address;
    @ManyToOne
    private Location location;
    @ManyToOne
    private Department department;
    @ManyToOne
    private DeviceType deviceType;

    public Device__() {
    }

    public Device__(String device, String any_desk_id, String mac_address, String ip_address, Department department, DeviceType deviceType) {
        this.device = device;
        this.any_desk_id = any_desk_id;
        this.mac_address = mac_address;
        this.ip_address = ip_address;
        this.department = department;
        this.deviceType = deviceType;
    }

    public Device__(String device, String any_desk_id, Department department, DeviceType deviceType) {
        this.device = device;
        this.any_desk_id = any_desk_id;
        this.department = department;
        this.deviceType = deviceType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAny_desk_id() {
        return any_desk_id;
    }

    public void setAny_desk_id(String any_desk_id) {
        this.any_desk_id = any_desk_id;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
