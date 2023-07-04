package model;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private int type;

    public int getType() {
        return type;
    }


    public User() {
        firstName = "";
        lastName = "";
        email = "";
    }

    public User(String firstName, String lastName, String userName, int type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.type = type;
    }
    
    public User(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}