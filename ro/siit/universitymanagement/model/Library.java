package ro.siit.universitymanagement.model;

public class Library extends Room {
    private int numberOfBooks;

    public Library(String name, int numberOfSeats, int numberOfBooks) {
        super(name, numberOfSeats);
        this.numberOfBooks = numberOfBooks;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}
