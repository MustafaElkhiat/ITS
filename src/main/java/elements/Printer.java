package elements;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Printer")
public class Printer extends Device {
    @Column(name = "toner_num")
    private String tonerNumber;
    @Column(name = "employee_code")
    private String employeeCode;
    @ManyToOne
    private PrinterConnection printerConnection;
    @ManyToOne
    private Employee employee;

    public Printer() {
    }

    public Printer(String device, String mac_address, String ip_address, LocationDepartment locationDepartment, DeviceType deviceType, String tonerNumber, PrinterConnection printerConnection, Employee employee) {
        super(device, mac_address, ip_address, locationDepartment, deviceType);
        this.tonerNumber = tonerNumber;
        this.printerConnection = printerConnection;
        this.employee = employee;
    }

    public Printer(String device, String mac_address, String ip_address, LocationDepartment locationDepartment, DeviceType deviceType, String tonerNumber, String employeeCode, PrinterConnection printerConnection) {
        super(device, mac_address, ip_address, locationDepartment, deviceType);
        this.tonerNumber = tonerNumber;
        this.employeeCode = employeeCode;
        this.printerConnection = printerConnection;
    }

    public String getTonerNumber() {
        return tonerNumber;
    }

    public void setTonerNumber(String tonerNumber) {
        this.tonerNumber = tonerNumber;
    }

    public PrinterConnection getPrinterConnection() {
        return printerConnection;
    }

    public void setPrinterConnection(PrinterConnection printerConnection) {
        this.printerConnection = printerConnection;
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
