package ro.siit.universitymanagement.model;

import java.util.*;

public class Faculty {
    private final String name;
    private final String address;
    private String deanName; // decan
    private final String shortName;

    private final FacultyProfileEnum profile;

    private Set<Course> courses = new TreeSet();
    private Set<Room> rooms = new TreeSet<>();
    private Map<String, Employee> employees = new TreeMap();
    private Map<String, Student> students = new TreeMap();


    public Faculty(String name, String deanName, String address, String shortName, FacultyProfileEnum profile) {
        this.name = name;
        this.deanName = deanName;
        this.address = address;
        this.shortName = shortName;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDeanName() {
        return deanName;
    }

    public void setDeanName(String deanName) {
        this.deanName = deanName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setCourses(Set<Course> courses){
        this.courses = courses;
    }
    public Set<Course> getCourses() {
        return courses;
    }

    public String getProfile() {
        return profile.toString();
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<String, Employee> employees) {
        this.employees = employees;
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public void setStudents(Map<String, Student> students) {
        this.students = students;
    }

    public String printCourses(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t\tCourses: ");
        for ( Course course : courses ){
            sb.append("\n\t\t\t\t" + course.toString());
        }
        return sb.toString();
    }

    public String printEmployees(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t\tEmployees: ");
        for ( Employee employee : employees.values() ){
            sb.append("\n\t\t\t\t" + employee.toString());
        }
        return sb.toString();
    }

    public String printStudents(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t\tStudents: ");
        for ( Student student : students.values() ){
            sb.append("\n\t\t\t\t" + student.toString());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return  " - " + this.getName() +
                ", address='" + this.getAddress() + '\'' +
                ", profile='" + this.getProfile() + '\'' +
                ", deanName='" + this.getDeanName() + '\'' +
                ":" + printCourses()
                + printEmployees()
                + printStudents();
    }

    @Override
    public boolean equals(Object o) {
        return Objects.equals(getName(), o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
