package sqlserver_elements;


import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "SescoEmployees")
public class Employees {
    @Id
    @Column(name = "Employee_Code")
    private String Employee_Code;
    @Column(name = "Employee_Name_1_English")
    private String Employee_Name_1_English;
    @Column(name = "Manager_Name_2_English")
    private String Manager_Name_2_English;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Mobile")
    private String Mobile;
    @Column(name = "Site_1_English")
    private String Site_1_English;
    @Column(name = "Department_1_English")
    private String Department_1_English;
    @Column(name = "Section_1_English")
    private String Section_1_English;
    @Column(name = "Division_1_English")
    private String Division_1_English;
    @Column(name = "Position_2_English")
    private String Position_2_English;

    public Employees() {
    }

    public String getEmployee_Code() {
        return Employee_Code;
    }

    public String getEmployee_Name_1_English() {
        return Employee_Name_1_English;
    }

    public String getManager_Name_2_English() {
        return Manager_Name_2_English;
    }

    public String getEmail() {
        return Email;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getSite_1_English() {
        return Site_1_English;
    }

    public String getDepartment_1_English() {
        return Department_1_English;
    }

    public String getSection_1_English() {
        return Section_1_English;
    }

    public String getDivision_1_English() {
        return Division_1_English;
    }

    public String getPosition_2_English() {
        return Position_2_English;
    }
}
