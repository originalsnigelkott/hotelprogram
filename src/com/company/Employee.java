package com.company;

public abstract class Employee extends Person implements Comparable<Employee> {

    public enum SortEmployeeBy {
        ID,
        NAME,
        DATE_OF_BIRTH,
    }

    private static SortEmployeeBy sortBy = SortEmployeeBy.NAME;
    private double hourlySalary; //TODO: delete this? no real use atm
    private double hoursPerWeek;
    private double weeklySalary;
    private int employeeID;
    private static int counter; //TODO: fix the counter, worst case: load int from file.

    public Employee(String firstName, String lastName, String dateOfBirth, double hourlySalary, double hoursPerWeek) {
        super(firstName, lastName, dateOfBirth);
        this.hourlySalary = hourlySalary;
        this.hoursPerWeek = hoursPerWeek;
        weeklySalary = hoursPerWeek * hourlySalary;
        employeeID = generateEmployeeID();
    }
    //TODO: add employeeID per class, example: 11001 manager, 12001 cleaner, 13001 receptionist or R10001, C10001, M10001
    private int generateEmployeeID() {
        counter++;
        String employeeID = null;
        if (counter < 10) {
            employeeID = "1000" + counter;
        } else if (counter < 100) {
            employeeID = "100" + counter;
        } else if (counter < 1000) {
            employeeID = "10" + counter;
        } else if (counter < 10000) {
            employeeID = "1" + counter;
        }
        return Integer.parseInt(employeeID);
    }

    @Override
    public String toString() {
        String output = String.format("" +
                        "EmployeeID: %d\n" +
                        "Role: %s\n" +
                        "%s, %s\n" +
                        "Date of birth: %s\n" +
                        "Salary: %.2f\n" +
                        "Hours/week: %.2f\n" +
                        "-----------------------"
                , employeeID, this.getClass().getSimpleName(), super.getLastName(), super.getFirstName(), super.getDateOfBirth(), weeklySalary, hoursPerWeek);
        return output;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setSortEmployeeBy(SortEmployeeBy sortEmployeeBy) {
        this.sortBy = sortEmployeeBy;
    }
    public SortEmployeeBy getSortEmployeeBy() {
        return sortBy;
    }
    public int compareTo(Employee employee) {
        switch (employee.getSortEmployeeBy()) {
            case ID: {
                return getEmployeeID() - employee.getEmployeeID();
            }
            case DATE_OF_BIRTH: {
                return getDateOfBirth().compareTo(employee.getDateOfBirth());
            }
            default:
                return getLastName().compareTo(employee.getLastName());
        }
    }
}
