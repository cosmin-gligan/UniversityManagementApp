package ro.siit.universitymanagement.model;

public class Employee extends Person  {
    private final String employeeID;//marca angajat
    private Number income;
    private DepartmentEnum department;

    public Employee(String firstName, String lastName, String cnp, int age, String employeeID, Number income, DepartmentEnum department) {
        super(firstName, lastName, cnp, age);
        this.employeeID = employeeID;
        this.income = income;
        this.department = department;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public Number getIncome() {
        return income;
    }

    public void setIncome(Number income) {
        this.income = income;
    }

    public DepartmentEnum getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEnum department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return " - " +
                this.getFullName() +
                ", cnp='" + this.getCnp() + '\'' +
                ", age=" + this.getAge() +
                ", gender='" + this.getGender() + '\'' +
                ", income=" + this.getIncome() +
                ", department='" + this.getDepartment().toString() + '\'';
    }
}
