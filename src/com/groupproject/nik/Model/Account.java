package com.groupproject.nik.Model;

public class Account {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private static int id; // auto-increment
    private boolean isAdmin;

    public Account(){
        this.username = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        id++;
        this.isAdmin = false;
    }
    public Account(String username, String password, String firstName, String lastName, int age, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        id++;
        this.isAdmin = isAdmin;
    }

    // username
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    // password
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    // firstName
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    // lastName
    public String getLastName() {return lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}

    // age
    public int getAge(){return this.age;}
    public void setAge(int age){this.age = age;}

    // id
    public int getId() {return id;}

    // isAdmin
    public boolean isAdmin(){return isAdmin;}
    public void setAdmin(boolean isAdmin){this.isAdmin = isAdmin;}
}
