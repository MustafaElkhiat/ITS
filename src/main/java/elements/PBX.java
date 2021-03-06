package elements;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("PBX")
public class PBX extends Device {
    @Column(name="device_num")
    private String deviceNum;
    @Column(name = "employee_code")
    private String employeeCode;
    @ManyToOne
    private Employee employee;

    public PBX() {
    }

    public PBX(String device, String mac_address, String ip_address, LocationDepartment locationDepartment, DeviceType deviceType, String deviceNum, Employee employee) {
        super(device, mac_address, ip_address, locationDepartment, deviceType);
        this.deviceNum = deviceNum;
        this.employee = employee;
    }

    public PBX(String device, String mac_address, String ip_address, LocationDepartment locationDepartment, DeviceType deviceType, String deviceNum, String employeeCode) {
        super(device, mac_address, ip_address, locationDepartment, deviceType);
        this.deviceNum = deviceNum;
        this.employeeCode = employeeCode;
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
}
