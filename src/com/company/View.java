package com.company;

import java.util.Scanner;

/**
 * <h1>View</h1>
 * This singleton class handles all the output and input in the console.
 *
 * @author originalsnigelkott
 * @version 1.0
 */
public class View {
    /**
     * This enum is for showing and choosing main menu options
     */
    public enum MainMenuItem implements MenuOutput {
        QUIT("Quit"),
        ADMINISTRATOR_SUB_MENU("Show admin menu"),
        RECEPTION_SUB_MENU("Show reception menu"),
        LOAD("Load data from previous session"),
        HELP("Help");

        private String menuOutput;
        private String menuHeadline = "Main menu";

        MainMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuHeadline() {
            return menuHeadline;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    /**
     * This enum is for showing and choosing admin menu options
     */
    public enum AdminMenuItem implements MenuOutput {
        BACK("Back"),
        HIRE("Hire employee"),
        DISMISS("Dismiss employee"),
        SHOW("Show employees");

        private String menuOutput;
        private String menuHeadline = "Main menu/Admin";

        AdminMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuHeadline() {
            return menuHeadline;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    /**
     * This enum is for showing and choosing employee type menu options
     */
    public enum hireEmployeeTypeMenuItem implements MenuOutput {
        BACK("Back"),
        CLEANER("Cleaner"),
        MANAGER("Manager"),
        RECEPTIONIST("Receptionist");

        private String menuOutput;
        private String menuHeadline = "Main menu/Admin/Hire";


        hireEmployeeTypeMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuHeadline() {
            return menuHeadline;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    /**
     * This enum is for showing and choosing show employee menu options
     */
    public enum ShowEmployeeTypeMenuItem implements MenuOutput {
        BACK("Back"),
        CLEANER("Show cleaners"),
        MANAGER("Show manager"),
        RECEPTIONIST("Show receptionist"),
        ALL("Show all"),
        SET_SORTING("Set sorting method");

        String menuOutput;
        String menuHeadline = "Main menu/Admin/Show";

        ShowEmployeeTypeMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuHeadline() {
            return menuHeadline;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    /**
     * This enum is for showing and choosing sorting menu
     */
    public enum SortEmployeeByMenuItem implements MenuOutput {
        BACK("Back"),
        NAME("Sort by name"),
        DATE_OF_BIRTH("Sort by date of birth"),
        ID("Sort by employeeID");

        String menuOutput;
        String menuHeadline = "Main menu/Admin/Show/Set sorting method";

        SortEmployeeByMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuHeadline() {
            return menuHeadline;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    /**
     * This enum is for showing and choosing reception menu options
     */
    public enum ReceptionMenuItem implements MenuOutput {
        BACK("Back"),
        ROOMS("Rooms"),
        GUESTS("Guests");

        String menuOutput;
        String menuHeadline = "Main menu/Reception";

        ReceptionMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuHeadline() {
            return menuHeadline;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    /**
     * This enum is for showing and choosing room menu options
     */
    public enum RoomsMenuItem implements MenuOutput {
        BACK("Back"),
        SHOW_ALL_ROOMS("Show all rooms");

        String menuOutput;
        String menuHeadline = "Main menu/Reception/Rooms";

        RoomsMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuHeadline() {
            return menuHeadline;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    /**
     * Contains the instance of the class
     */
    private static View instance = null;
    /**
     * The scanner used for input
     */
    private Scanner input = new Scanner(System.in);

    /**
     * Private constructor for the View class
     */
    private View() {

    }

    /**
     * This method checks if there is an instance of View, if there isn't it creates one, and returns it
     *
     * @return returns the instance of the View class
     */
    public static View getInstance() {
        if (instance == null) {
            return new View();
        }
        return instance;
    }

    /**
     * This method outputs a menu in the console.
     *
     * @param menuItems The menu type to output
     * @param <E>       A generic element that implements MenuOutput
     */
    public <E extends MenuOutput> void showMenu(E[] menuItems) {
        System.out.printf("" +
                        "----------\n" +
                        "%s\n" +
                        "----------\n"
                , menuItems[0].getMenuHeadline());
        for (int i = 1; i < menuItems.length; i++) {
            System.out.printf("%d. %s\n", i, menuItems[i].getMenuOutput());
        }
        System.out.printf("0. %s\n", menuItems[0].getMenuOutput());
    }

    /**
     * This method gets the users choice from the menu previously shown
     *
     * @param menuItems The menu to make a choice from
     * @param <E>       A generic element
     * @return
     */
    public <E> E inputMenuChoice(E[] menuItems) {
        String userInput;
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.menuChoiceIsValid(userInput, menuItems.length));
        return menuItems[Integer.parseInt(userInput)];
    }

    /**
     * This method outputs a warning message and asks user to confirm their choice
     *
     * @param warningMessage The warning message to be output to user
     * @return Returns true or false based on the users choice
     */
    public boolean isConfirmed(String warningMessage) {
        System.out.printf("%s. Do you wish to proceed? (Y/n)\n", warningMessage);
        String userInput = input.nextLine();
        if (userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("YES")) {
            return true;
        } else if (userInput.equalsIgnoreCase("N") || userInput.equalsIgnoreCase("NO")) {
            return false;
        } else {
            showErrorMessage("Only yes or no allowed. Try again.");
            return isConfirmed(warningMessage);
        }
    }

    //TODO: use this instead of other string input methods?
    //inputDateOfBirth() uses other FormatChecker.
    //Still use it for all and check in HotelProgram or keep inputDateOfBirth()?
    public String inputString(String message) {
        showMessage(message);
        String userInput;
        do {
            userInput = input.nextLine();
        } while(!FormatCheckers.stringIsValid(userInput));
        return userInput;
    }
    /**
     * This method reads a name from the user
     *
     * @param type This argument is to output first or last in the prompt
     * @return Returns the string input by the user
     */
    public String inputName(String type) {
        System.out.printf("Enter %s name:\n", type);
        String userInput;
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.stringIsValid(userInput));
        return userInput;
    }

    /**
     * This method reads a date of birth from the user
     *
     * @return Returns the string input by the user
     */
    public String inputDateOfBirth() {
        System.out.println("Enter date of birth: (YYYYMMDD)");
        String userInput;
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.formatIsCorrect(userInput, 8));
        return userInput;
    }

    /**
     * This method reads a salary from the user
     *
     * @return Returns the double input by the user
     */
    public double inputSalary() {
        String userInput;
        System.out.println("Input employees hourly salary: ($$.¢¢ or $$)");
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.stringIsDouble(userInput));
        return Double.parseDouble(userInput);
    }

    /**
     * This method reads a hours worked per week from the user
     *
     * @return Returns the double input by the user
     */
    public double inputHoursPerWeek() {
        String userInput;
        System.out.println("Input employees work hours/week: (HH or HH.hh)");
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.stringIsDouble(userInput));
        return Double.parseDouble(userInput);
    }

    /**
     * This method reads an employee ID from the user
     *
     * @return Returns the integer input byt the user
     */
    public int inputEmployeeID() {
        String userInput;
        System.out.println("Input employeeID: (1XXXX)");
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.formatIsCorrect(userInput, 5));
        return Integer.parseInt(userInput);
    }

    /**
     * This method prints a message
     *
     * @param message The message to be displayed
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * This method prints an error message
     *
     * @param errorMessage Description of the error that occured.
     */
    public void showErrorMessage(String errorMessage) {
        String output = String.format("Error: %s", errorMessage);
        System.out.println(output);
    }

    /**
     * This method prints toString() method of an element
     *
     * @param element The element to be printed
     * @param <E>     A generic element, in this case any element with a toString method
     */
    public <E> void showElement(E element) {
        System.out.println(element);
    }
}
