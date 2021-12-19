package ro.siit.universitymanagement.model;

public enum FacultyProfileEnum {
    REAL("Real"),
    UMAN("Uman");

    private final String name;

    FacultyProfileEnum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
