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
        String string = "0";
        assertTrue(FormatCheckers.menuChoiceIsValid(string, 10));
        string = "11";
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
    public void formatIsCorrect() {
        String string = "12345";
        assertTrue(FormatCheckers.formatIsCorrect(string,5));
        string = "1234567";
        assertFalse(FormatCheckers.formatIsCorrect(string,5));
        string = "1234";
        assertFalse(FormatCheckers.formatIsCorrect(string,5));
        string = "abcdefgh";
        assertFalse(FormatCheckers.formatIsCorrect(string,5));
        string = "-1234";
        assertFalse(FormatCheckers.formatIsCorrect(string,5));
        string = "12345678";
        assertTrue(FormatCheckers.formatIsCorrect(string,8));
        string = "123456789";
        assertFalse(FormatCheckers.formatIsCorrect(string,8));
        string = "1234567";
        assertFalse(FormatCheckers.formatIsCorrect(string,8));
        string = "abcdefgh";
        assertFalse(FormatCheckers.formatIsCorrect(string,8));
        string = "-1234567";
        assertFalse(FormatCheckers.formatIsCorrect(string,8));
    }
}