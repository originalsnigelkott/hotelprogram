package com.company;

public class Guest extends Person {
    private String nationality;

    public Guest(String firstName, String lastName, String dateOfBirth, String nationality) {
        super(firstName, lastName, dateOfBirth);
        this.nationality = nationality;
    }
}
