package ro.siit.universitymanagement.services;

import ro.siit.universitymanagement.model.Course;
import ro.siit.universitymanagement.model.Faculty;

public interface MinimumRequirements {

    void populateUniversities();
    void printInfo4Universities();
    void populateFacultyList();
    void populateCourses4Faculty(Faculty faculty);
    void populateCourses();
    void populateTeachers4Courses(Course course);
    void populateEmployees4Faculty(Faculty faculty);
    void populatePersons();
    void populateStudents();
    void populateStudents4Courses(Course course);
    void populateStudents4Faculty(Faculty faculty);

}
