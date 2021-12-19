package ro.siit.universitymanagement.services;

import ro.siit.universitymanagement.model.Faculty;

public interface MinimumRequirements {

    void populateUniversities();

    void printUniversities();

    void populateFacultyList();
    void populateCourses4Faculty(Faculty faculty);

    void populateCourses();
}
