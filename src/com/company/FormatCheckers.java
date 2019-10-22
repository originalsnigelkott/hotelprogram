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
            if (Integer.parseInt(menuChoice) <= noOfChoices && Integer.parseInt(menuChoice) > 0) {
                return true;
            } else {
                View.getInstance().showErrorMessage("No such choice.");
            }
        }
        return false;
    }
    //TODO: fix this, maybe a separator issue.
    /*
        public static boolean doubleFormatIsValid(String string) {
            if (stringIsDouble(string)) {
                if (doubleHas2IntegersAnd2Decimals(string)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean doubleHas2IntegersAnd2Decimals(String string) {
            String[] split = string.split(".");
            if (split[0].length() < 3 && split[0].length() > 0) {
                if (split[1].length() < 3) {
                    return true;
                } else {
                    View.getInstance().showErrorMessage("Decimals have to be less than 3");
                }
            } else {
                View.getInstance().showErrorMessage("Integers has to be less than 100 or more than 1");
            }
            return false;
        }
    */
    public static boolean stringIsValid(String string) {
        if (!string.equals("")) {
            return true;
        } else {
            View.getInstance().showErrorMessage("Invalid input.");
        }
        return false;
    }
    //TODO: make a formatIsCorrect to replace dateOfBirthFormatIsCorrect and employeeIDInputIsValid
    public static boolean dateOfBirthFormatIsCorrect(String string) {
        if (stringIsIntegers(string)) {
            if (Integer.parseInt(string) > 0) {
                if (string.length() == 8) {
                    return true;
                }
            }
        }
        View.getInstance().showErrorMessage("Wrong format.");
        return false;
    }

    public static boolean employeeIDInputIsValid(String string) {
        if (stringIsIntegers(string)) {
            if (Integer.parseInt(string) > 0) {
                if (string.length() == 5) {
                    return true;
                }
            }
        }
        View.getInstance().showErrorMessage("Wrong format.");
        return false;
    }
}
