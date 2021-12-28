package ro.siit.universitymanagement.model;

public class Student extends Person {
    private final int studentID; //numarul matricol
    private double averageGrade; //medie tuturor materiilor

    public Student(String firstName, String lastName, String cnp, int age, int studentID, double averageGrade) {
        super(firstName, lastName, cnp, age);
        this.studentID = studentID;
        this.averageGrade = averageGrade;
    }

    public int getStudentID() {
        return studentID;
    }
    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return " - " +
                " " + getFullName() +
                ", cnp='" + getCnp() + '\'' +
                ", age=" + getAge() +
                ", gender='" + this.getGender() + '\'' +
                ", averageGrade='" + this.getAverageGrade() + '\'';
    }
}
