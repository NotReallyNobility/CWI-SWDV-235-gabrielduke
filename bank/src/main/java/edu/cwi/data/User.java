package edu.cwi.data;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private edu.cwi.data.enums.AppRole role;

    public User() {

    }
    public User(int id, String username, String password, String email, String firstName, String lastName, edu.cwi.data.enums.AppRole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public edu.cwi.data.enums.AppRole getRole() {
        return role;
    }


    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(edu.cwi.data.enums.AppRole role) {
        this.role = role;
    }
}
