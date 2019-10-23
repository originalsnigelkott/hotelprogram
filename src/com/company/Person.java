package com.company;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String dateOfBirth;


    public Person(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
