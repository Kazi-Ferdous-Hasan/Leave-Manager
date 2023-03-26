package leave.manager;

public class UsedLeave {
    Employee  employee;
    int casualLeave;
    int sickLeave;
    int annualLeave;
    int maternityLeave;
    String year;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getCasualLeave() {
        return casualLeave;
    }

    public void setCasualLeave(int casualLeave) {
        this.casualLeave = casualLeave;
    }

    public int getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(int sickLeave) {
        this.sickLeave = sickLeave;
    }

    public int getAnnualLeave() {
        return annualLeave;
    }

    public void setAnnualLeave(int annualLeave) {
        this.annualLeave = annualLeave;
    }

    public int getMaternityLeave() {
        return maternityLeave;
    }

    public void setMaternityLeave(int maternityLeave) {
        this.maternityLeave = maternityLeave;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    
}
