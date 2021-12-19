package ro.siit.universitymanagement.model;

public class Student extends Person {
    private final String studentID; //numarul matricol

    public Student(String firstName, String lastName, String cnp, int age, String studentID) {
        super(firstName, lastName, cnp, age);
        this.studentID = studentID;
    }
}
