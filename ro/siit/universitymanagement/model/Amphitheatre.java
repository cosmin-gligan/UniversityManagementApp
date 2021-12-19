package ro.siit.universitymanagement.model;

public class Amphitheatre extends Room {
    private final int rows;

    public Amphitheatre(String name, int numberOfSeats, int rows) {
        super(name, numberOfSeats);
        this.rows = rows;
    }
}
