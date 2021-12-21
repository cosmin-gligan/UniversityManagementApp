package ro.siit.universitymanagement.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private String cnp;
    private int age;
    private String gender;

    public Person(String firstName, String lastName, String cnp, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.age = age; //in viitor facem metoda sa extragem varsta din CNP
        this.gender = getGenderForCnp(cnp); // am extras sexul din CNP
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFullName(){
        return this.getFirstName() + " " + this.getLastName();
    }

    //intoarce sex-ul unei persoane in functie de CNO
    @NotNull
    private String getGenderForCnp(String cnp) {

        int firstDigit = Integer.parseInt(cnp.substring(0, 1));

        if (firstDigit == 1 || firstDigit == 5) {
            return "M";
        }

        if (firstDigit == 2 || firstDigit == 6){
            return "F";
        }
        //intoarcem ? daca nu am reusit sa determinam sexul ( in viitor exception )
        return "?";
    }

    //folosim CNP-ul pt. a determina egalitatea
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.getCnp() == person.getCnp();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCnp());
    }

    @Override
    public int compareTo(Person o){
        return this.getCnp().compareTo(o.getCnp());
    }

    @Override
    public String toString() {
        return "" +
                " fullName='" + this.getFullName() + '\'' +
                ", cnp='" + this.getCnp() + '\'' +
                ", age=" + this.getAge() +
                ", gender='" + this.getGender() + '\'';
    }
}
