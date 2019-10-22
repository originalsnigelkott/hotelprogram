package com.company;

public class Guest extends Person {
    private String nationality;

    public Guest (String firstname, String lastName, String dateOfBirth, String nationality) {
        super(firstname, lastName, dateOfBirth);
        this.nationality = nationality;
    }
}
