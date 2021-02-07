package com.tts;

public class Entry {

    // list variables that user will need to input
    String firstName;
    String lastName;
    String email;
    String phone;



    // create constructor for an entry to the book
    public Entry(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    // create getters and setters
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString(){
        return "\n************" +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nPhone Number: " + phone +
                "\nEmail Address: " + email +
                "\n************";
    }
}
