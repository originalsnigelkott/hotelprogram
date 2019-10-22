package com.company;

import static org.junit.Assert.*;

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
        string = "791472848724894809546656465654513213163514654654613135654654654654654313216546857498798798798798798798674684684986749874984654654654698645674567474567387508972587509827345098723409857203948.7234985720938759023745072340572309485709283475098723409570239847509823745098723409857092834750982374509873240985603276450876234058762304876508723465089762349875692384659823764598632498562398745698237459873264598632498573294856983246598723649857623984659823764598762340560193265091620948712309847120983740912873490817230984720198374098127340987120394701293874098127340987120983470982310596213098560287315607821346087520135098324750893247089572389475092375";
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
    }
}