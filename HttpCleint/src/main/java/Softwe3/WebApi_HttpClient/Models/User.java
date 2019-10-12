package Softwe3.WebApi_HttpClient.Models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    //@JsonProperty("id")
    private int id;
    //@JsonProperty("firstName")
    private String firstName;
    //@JsonProperty("lastName")
    private String lastName;

    public User() {}
    public User(int _id, String _firstName, String _lastName) {
       ; this.setId(_id);
        this.setFirstName(_firstName);
        this.setLastName(_lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
