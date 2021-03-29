package elements;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PC")
public class PC extends Device {
    @Column(name = "login_name")
    private String loginName;
    @Column(name = "computer_name")
    private String computerName;
    @Column(name = "HD")
    private String HD;
    @Column(name = "RAM")
    private String RAM;
    @Column(name = "CPU")
    private String CPU;
    @Column(name = "monitor")
    private String monitor;
    @Column(name = "monitor_serial_num")
    private String monitorSerialNum;
    @Type(type = "true_false")
    @Column(name = "internet")
    private boolean internet;
    @Column(name = "employee_code")
    private String employeeCode;
    @ManyToOne
    private PCType pcType;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private OS os;

    public PC() {
    }

    public PC(String loginName, String computerName, String HD, String RAM, String CPU, String monitor, String monitorSerialNum, boolean internet, Employee employee, OS os, PCType pcType) {
        this.loginName = loginName;
        this.computerName = computerName;
        this.HD = HD;
        this.RAM = RAM;
        this.CPU = CPU;
        this.monitor = monitor;
        this.monitorSerialNum = monitorSerialNum;
        this.internet = internet;
        this.employee = employee;
        this.os = os;
        this.pcType = pcType;
    }

    public PC(String device, String mac_address, String ip_address, LocationDepartment locationDepartment, DeviceType deviceType, String loginName, String computerName, String HD, String RAM, String CPU, String monitor, String monitorSerialNum, boolean internet, Employee employee, OS os, PCType pcType) {
        super(device, mac_address, ip_address,locationDepartment, deviceType);
        this.loginName = loginName;
        this.computerName = computerName;
        this.HD = HD;
        this.RAM = RAM;
        this.CPU = CPU;
        this.monitor = monitor;
        this.monitorSerialNum = monitorSerialNum;
        this.internet = internet;
        this.employee = employee;
        this.os = os;
        this.pcType = pcType;
    }

    public PC(String device, String mac_address, String ip_address, LocationDepartment locationDepartment, DeviceType deviceType, String loginName, String computerName, String HD, String RAM, String CPU, String monitor, String monitorSerialNum, boolean internet, String employeeCode, PCType pcType, OS os) {
        super(device, mac_address, ip_address, locationDepartment, deviceType);
        this.loginName = loginName;
        this.computerName = computerName;
        this.HD = HD;
        this.RAM = RAM;
        this.CPU = CPU;
        this.monitor = monitor;
        this.monitorSerialNum = monitorSerialNum;
        this.internet = internet;
        this.employeeCode = employeeCode;
        this.pcType = pcType;
        this.os = os;
    }

    public PC(String device, LocationDepartment locationDepartment, DeviceType deviceType, String loginName, String computerName, String HD, String RAM, String CPU, String monitor, String monitorSerialNum, boolean internet, Employee employee, OS os, PCType pcType) {
        super(device, locationDepartment, deviceType);
        this.loginName = loginName;
        this.computerName = computerName;
        this.HD = HD;
        this.RAM = RAM;
        this.CPU = CPU;
        this.monitor = monitor;
        this.monitorSerialNum = monitorSerialNum;
        this.internet = internet;
        this.employee = employee;
        this.os = os;
        this.pcType = pcType;
    }


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getHD() {
        return HD;
    }

    public void setHD(String HD) {
        this.HD = HD;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getMonitorSerialNum() {
        return monitorSerialNum;
    }

    public void setMonitorSerialNum(String monitorSerialNum) {
        this.monitorSerialNum = monitorSerialNum;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
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

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public PCType getPcType() {
        return pcType;
    }

    public void setPcType(PCType pcType) {
        this.pcType = pcType;
    }
}
