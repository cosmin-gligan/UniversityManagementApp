package ro.siit.universitymanagement.model;

public class Laboratory extends Room {
    LaboratoryTypeEnum labType;

    public Laboratory(String name, int numberOfSeats, LaboratoryTypeEnum labType) {
        super(name, numberOfSeats);
        this.labType = labType;
    }
}
