package ro.siit.universitymanagement.model;

public class Professor extends Person {
    Number income;

    public Professor(String firstName, String lastName, String cnp, int age, Number income) {
        super(firstName, lastName, cnp, age);
        this.income = income;
    }

    public Number getIncome() {
        return income;
    }

    public void setIncome(Number income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return " - " +
                this.getFullName() +
                ", cnp='" + getCnp() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", income=" + getIncome();
    }
}