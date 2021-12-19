package ro.siit.universitymanagement.model;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public final class University {

    private final String name;
    private final int foundationYear;

    private Map<String, Faculty> facultyMap = new TreeMap<>();
    private String address;
    private final String shortName;

    public University(String name, int foundationYear, String address, String shortName) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.address = address;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public Map<String, Faculty> getFacultyMap() {
        return facultyMap;
    }

    public void setFacultyMap(Map<String, Faculty> facultyMap) {
        this.facultyMap = facultyMap;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShortName() {
        return shortName;
    }

    public String printFaculties(){

        StringBuilder sb = new StringBuilder();
        sb.append("\n\tFaculties: ");
        for ( Faculty faculty : facultyMap.values() ){
            sb.append("\n\t\t" + faculty.toString());
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "University: " +
                "name='" + name + '\'' +
                ", foundationYear=" + foundationYear +
                ", address='" + address + '\'' + printFaculties();
    }

    @Override
    public boolean equals(Object o) {
        return Objects.equals(this.shortName, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortName);
    }


}
