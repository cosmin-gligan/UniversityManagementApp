package ro.siit.universitymanagement.model;

public enum DepartmentEnum {
    CONTABILITATE("Contabilitate"),
    RESURSE_UMANE("Resurse Umane"),
    INTRETINERE("Intretinere"),
    PROFESORAT("Profesorat");

    private final String name;

    DepartmentEnum(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
