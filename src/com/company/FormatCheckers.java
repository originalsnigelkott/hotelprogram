package com.company;

public class FormatCheckers {
    public static boolean stringIsIntegers(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            View.getInstance().showErrorMessage("Only integers allowed.");
        }
        return false;
    }

    public static boolean stringIsDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (Exception e) {
            View.getInstance().showErrorMessage("Only double-values allowed.");
        }
        return false;
    }

    public static boolean menuChoiceIsValid(String menuChoice, int noOfChoices) {
        if (stringIsIntegers(menuChoice)) {
            if (Integer.parseInt(menuChoice) <= noOfChoices && Integer.parseInt(menuChoice) >= 0) {
                return true;
            } else {
                View.getInstance().showErrorMessage("No such choice.");
            }
        }
        return false;
    }
    
    public static boolean stringIsValid(String string) {
        if (!string.equals("")) {
            return true;
        } else {
            View.getInstance().showErrorMessage("Invalid input.");
        }
        return false;
    }

    public static boolean formatIsCorrect(String string, int stringLength) {
        if (stringIsIntegers(string)) {
            if (Integer.parseInt(string) > 0) {
                if (string.length() == stringLength) {
                    return true;
                }
            }
        }
        View.getInstance().showErrorMessage("Wrong format.");
        return false;
    }
}
