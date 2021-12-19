package ro.siit.universitymanagement.model;

public class Employee extends Person {
    private final String employeeID;
    private double salary;
    private DepartmentEnum department;

    protected Employee(String firstName, String lastName, String cnp, int age, String employeeID, double salary, DepartmentEnum department) {
        super(firstName, lastName, cnp, age);
        this.employeeID = employeeID;
        this.salary = salary;
        this.department = department;
    }
}
