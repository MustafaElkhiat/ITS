package elements;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "device")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "device")
    private String device;
    @Column(name = "office")
    private String office;
    @Column(name = "model")
    private String model;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "serial_num")
    private String serialNum;
    @Temporal(TemporalType.DATE)
    @Column(name = "purchase_date")
    private Date purchaseDate;
    @Type(type = "true_false")
    @Column(name = "need_to_upgrade")
    private boolean needToUpgrade;
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

    public Device() {
    }

    public Device(String device, String mac_address, String ip_address, Department department, DeviceType deviceType) {
        this.device = device;
        this.mac_address = mac_address;
        this.ip_address = ip_address;
        this.department = department;
        this.deviceType = deviceType;
    }

    public Device(String device, Department department, DeviceType deviceType) {
        this.device = device;
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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public boolean isNeedToUpgrade() {
        return needToUpgrade;
    }

    public void setNeedToUpgrade(boolean needToUpgrade) {
        this.needToUpgrade = needToUpgrade;
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
