package ro.siit.universitymanagement.model;

public enum LaboratoryTypeEnum {
    PHYSICS("physics"),
    CHEMISTRY("chemistry"),
    IT("it");

    private final String type;

    LaboratoryTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Type:" + getType() ;
    }
}
