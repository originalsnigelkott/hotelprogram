package com.company;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FormatCheckersTest {

    @org.junit.Test
    public void stringIsIntegers() {
        String string = "a";
        assertFalse(FormatCheckers.stringIsIntegers(string));
        string = "791472848724894809";
        assertFalse(FormatCheckers.stringIsIntegers(string));
        string = "1";
        assertTrue(FormatCheckers.stringIsIntegers(string));
    }

    @org.junit.Test
    public void stringIsDouble() {
        String string = "a";
        assertFalse(FormatCheckers.stringIsDouble(string));
        string = "35.50";
        assertTrue(FormatCheckers.stringIsDouble(string));
        string = "1";
        assertTrue(FormatCheckers.stringIsDouble(string));
    }

    @org.junit.Test
    public void menuChoiceIsValid() {
        String string = "1";
        assertTrue(FormatCheckers.menuChoiceIsValid(string, 10));
        string = "11";
        assertFalse(FormatCheckers.menuChoiceIsValid(string, 10));
        string = "0";
        assertFalse(FormatCheckers.menuChoiceIsValid(string, 10));
        string = "-1";
        assertFalse(FormatCheckers.menuChoiceIsValid(string, 10));
        string = "a";
        assertFalse(FormatCheckers.menuChoiceIsValid(string, 10));
        string = "hoppsan";
        assertFalse(FormatCheckers.menuChoiceIsValid(string, 10));
    }

    @org.junit.Test
    public void stringIsValid() {
        String string = "";
        assertFalse(FormatCheckers.stringIsValid(string));
        string = "asd";
        assertTrue(FormatCheckers.stringIsValid(string));
    }

    @org.junit.Test
    public void dateOfBirthFormatIsCorrect() {
        String string = "12345678";
        assertTrue(FormatCheckers.dateOfBirthFormatIsCorrect(string));
        string = "123456789";
        assertFalse(FormatCheckers.dateOfBirthFormatIsCorrect(string));
        string = "1234567";
        assertFalse(FormatCheckers.dateOfBirthFormatIsCorrect(string));
        string = "abcdefgh";
        assertFalse(FormatCheckers.dateOfBirthFormatIsCorrect(string));
        string = "-1234567";
        assertFalse(FormatCheckers.dateOfBirthFormatIsCorrect(string));
    }

    @org.junit.Test
    public void employeeIDInputIsValid() {
        String string = "12345";
        assertTrue(FormatCheckers.employeeIDInputIsValid(string));
        string = "1234567";
        assertFalse(FormatCheckers.employeeIDInputIsValid(string));
        string = "1234";
        assertFalse(FormatCheckers.employeeIDInputIsValid(string));
        string = "abcdefgh";
        assertFalse(FormatCheckers.employeeIDInputIsValid(string));
        string = "-1234";
        assertFalse(FormatCheckers.employeeIDInputIsValid(string));
    }
}