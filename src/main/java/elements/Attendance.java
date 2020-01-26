package elements;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Attendance")
public class Attendance extends Device {
    @Column(name="subnet")
    private String subnet;
    @Column(name="gateway")
    private String gateway;

    public Attendance() {
    }

    public Attendance(String device, String mac_address, String ip_address, Department department, DeviceType deviceType, String subnet, String gateway) {
        super(device, mac_address, ip_address, department, deviceType);
        this.subnet = subnet;
        this.gateway = gateway;
    }

    public String getSubnet() {
        return subnet;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }
}
