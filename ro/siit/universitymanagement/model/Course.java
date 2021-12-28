package ro.siit.universitymanagement.model;

import java.util.Set;
import java.util.TreeSet;

public class Course implements Comparable<Course> {
    private final String name;
    private final String shortName;
    public Set<Professor> professorList = new TreeSet<>();
    public Set<Student> studentList = new TreeSet<>();

    public Course(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public Set<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(Set<Professor> professorList) {
        this.professorList = professorList;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }

    public String printProfessors(){

        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t\t\t\t\tProfessors: ");
        for ( Professor professor : getProfessorList() ){
            sb.append("\n\t\t\t\t\t\t" + professor.toString());
        }

        return sb.toString();
    }

    public String printStudents(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t\t\t\t\tStudents: ");
        for ( Student student : getStudentList() ){
            sb.append("\n\t\t\t\t\t\t" + student.toString());
        }

        return sb.toString();

    }


    @Override
    public String toString() {
        return " - " + this.getName() + printProfessors() + printStudents();
    }

    @Override
    public int compareTo(Course o){

        return this.getName().compareTo(o.getName());

    }
}
