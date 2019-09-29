package Softwe3.WebApiRest_MySql.Models;

public class User {
    private int id;
    private String FirstName;
    private  String LastName;

    public User(int id, String firstName, String lastName) {
        this.setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
