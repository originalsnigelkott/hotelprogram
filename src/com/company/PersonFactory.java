package com.company;

public class PersonFactory {
    public enum PersonType {
        GUEST,
        CLEANER,
        RECEPTIONIST,
        MANAGER,
    }

    public static Person createPerson(PersonType personType) {
        String firstName = View.getInstance().inputName("first");
        String lastName = View.getInstance().inputName("last");
        String dateOfBirth = View.getInstance().inputDateOfBirth();
        switch (personType) {
            case GUEST: {
                return new Guest(firstName, lastName, dateOfBirth, "");
            }
            case CLEANER: {
                Double hourlySalary = View.getInstance().inputSalary();
                Double hoursPerWeek = View.getInstance().inputHoursPerWeek();
                return new Cleaner(firstName, lastName, dateOfBirth, hourlySalary, hoursPerWeek);
            }
            case RECEPTIONIST: {
                Double hourlySalary = View.getInstance().inputSalary();
                Double hoursPerWeek = View.getInstance().inputHoursPerWeek();
                return new Receptionist(firstName, lastName, dateOfBirth, hourlySalary, hoursPerWeek);
            }
            case MANAGER: {
                Double hourlySalary = View.getInstance().inputSalary();
                Double hoursPerWeek = View.getInstance().inputHoursPerWeek();
                return new Manager(firstName, lastName, dateOfBirth, hourlySalary, hoursPerWeek);
            }
            default: {
                return null;
            }
        }
    }
}
