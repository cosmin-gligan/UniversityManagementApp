package ro.siit.universitymanagement.model;

import java.util.*;

public class Faculty {
    private final String name;
    private final String address;
    private String deanName; // decan
    private final String shortName;
    private Set<Course> courses = new TreeSet();
    private Set<Room> rooms = new TreeSet<>();
    private Set<Person> people = new TreeSet<>();

    public Faculty(String name, String deanName, String address, String shortName) {
        this.name = name;
        this.deanName = deanName;
        this.address = address;
        this.shortName = shortName;
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

    public String printCourses(){

        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t\tCourses: ");
        for ( Course course : courses ){
            sb.append("\n\t\t\t\t" + course.toString());
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return  " - " + this.getName() +
                ", address='" + this.getAddress() + '\'' +
                ", deanName='" + this.getDeanName() + '\'' +
                ":" + printCourses();
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
