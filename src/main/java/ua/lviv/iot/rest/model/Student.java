package ua.lviv.iot.rest.model;

public class Student {
    private String firstName;
    private String lastName;
    private Integer id;

    public Student(String firstName, String lastName) {
       this(firstName, lastName, 33);
    }

    public Student(String firstName, String lastName, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public Student() {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
