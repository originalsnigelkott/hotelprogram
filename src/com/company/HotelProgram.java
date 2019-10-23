package com.company;

import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;

public class HotelProgram {
    private static final int NUMBER_OF_FLOORS = 3;
    private ArrayList<Floor> floors = new ArrayList<>();
    private ArrayList<Employee> employees;
    private String employeesSaveFileName = "employees.ser";

    View view;

    public HotelProgram() {
        view = View.getInstance();
        for (int i = 0; i < NUMBER_OF_FLOORS; i++) {
            floors.add(new Floor(i + 1));
        }
        ///*
        employees = new ArrayList<>();
        employees.add(new Manager("Hästen", "Boss", "20090412", 44, 60));
        employees.add(new Receptionist("Saga", "Drake", "19251230", 14.99, 40));
        employees.add(new Receptionist("Per", "Dahlstedt", "19870918", 10.99, 35));
        employees.add(new Receptionist("Linnea", "Jonsson", "19850923", 20, 40));
        employees.add(new Receptionist("Balder", "Sörensen", "20110529", 13, 10));
        employees.add(new Receptionist("Frank", "Andersson", "20090412", 19.50, 25));
        employees.add(new Cleaner("Orvar", "Friberg", "19910418", 14, 20));
        employees.add(new Cleaner("Stina", "Strindberg", "19750123", 14, 40));
        employees.add(new Cleaner("Henrik", "Persson", "19601107", 14, 35));
        //*/
    }

    public void startProgram() {
        View.MainMenuItem mainMenuChoice;
        do {
            view.showMenu(View.MainMenuItem.values());
            mainMenuChoice = view.inputMenuChoice(View.MainMenuItem.values());
            switch (mainMenuChoice) {
                case ADMINISTRATOR_SUB_MENU: {
                    View.AdminMenuItem adminMenuChoice;
                    do {
                        view.showMenu(View.AdminMenuItem.values());
                        adminMenuChoice = view.inputMenuChoice(View.AdminMenuItem.values());
                        switch (adminMenuChoice) {
                            case HIRE: {
                                View.hireEmployeeTypeMenuItem employeeTypeMenuItem;
                                do {
                                    view.showMenu(View.hireEmployeeTypeMenuItem.values());
                                    employeeTypeMenuItem = view.inputMenuChoice(View.hireEmployeeTypeMenuItem.values());
                                    switch (employeeTypeMenuItem) {
                                        case CLEANER: {
                                            hireEmployee((Employee) PersonFactory.createPerson(PersonFactory.PersonType.CLEANER));
                                            break;
                                        }
                                        case MANAGER: {
                                            hireEmployee((Employee) PersonFactory.createPerson(PersonFactory.PersonType.MANAGER));
                                            break;
                                        }
                                        case RECEPTIONIST: {
                                            hireEmployee((Employee) PersonFactory.createPerson(PersonFactory.PersonType.RECEPTIONIST));
                                            break;
                                        }
                                        case BACK: {
                                            break;
                                        }
                                        default: {
                                            view.showErrorMessage("Invalid choice. Try again");
                                        }
                                    }
                                } while (employeeTypeMenuItem != View.hireEmployeeTypeMenuItem.BACK);
                                saveObjectsToFile(employeesSaveFileName, employees);
                                break;
                            }
                            case DISMISS: {
                                int employeeID = view.inputEmployeeID();
                                if (view.isConfirmed("Employee will be permanently removed")) {
                                    dismissEmployee(employeeID);
                                    saveObjectsToFile(employeesSaveFileName, employees);
                                }
                                break;
                            }
                            case SHOW: {
                                View.ShowEmployeeTypeMenuItem showEmployeeTypeMenuChoice;
                                Collections.sort(employees);
                                do {
                                    String packageName = "com.company.";
                                    view.showMenu(View.ShowEmployeeTypeMenuItem.values());
                                    showEmployeeTypeMenuChoice = view.inputMenuChoice(View.ShowEmployeeTypeMenuItem.values());
                                    switch (showEmployeeTypeMenuChoice) {
                                        case CLEANER: {
                                            showEmployees(packageName + "Cleaner");
                                            break;
                                        }
                                        case MANAGER: {
                                            showEmployees(packageName + "Manager");
                                            break;
                                        }
                                        case RECEPTIONIST: {
                                            showEmployees(packageName + "Receptionist");
                                            break;
                                        }
                                        case ALL: {
                                            showEmployees(packageName + "Employee");
                                            break;
                                        }
                                        case SET_SORTING: {
                                            if (employees.size() != 0) {
                                                View.SortEmployeeByMenuItem sortByMenuItemChoice;
                                                view.showMenu(View.SortEmployeeByMenuItem.values());
                                                sortByMenuItemChoice = view.inputMenuChoice(View.SortEmployeeByMenuItem.values());
                                                switch (sortByMenuItemChoice) {
                                                    case ID: {
                                                        employees.get(0).setSortEmployeeBy(Employee.SortEmployeeBy.ID);
                                                        break;
                                                    }
                                                    case NAME: {
                                                        employees.get(0).setSortEmployeeBy(Employee.SortEmployeeBy.NAME);
                                                        break;
                                                    }
                                                    case DATE_OF_BIRTH: {
                                                        employees.get(0).setSortEmployeeBy(Employee.SortEmployeeBy.DATE_OF_BIRTH);
                                                        break;
                                                    }
                                                    default: {
                                                        view.showErrorMessage("Invalid choice. Try again.");
                                                    }
                                                }
                                                Collections.sort(employees);
                                            } else {
                                                view.showErrorMessage("No employees to sort.");
                                            }
                                            break;
                                        }
                                        case BACK: {
                                            break;
                                        }
                                        default: {
                                            view.showErrorMessage("Invalid choice. Try again.");
                                        }
                                    }
                                } while (showEmployeeTypeMenuChoice != View.ShowEmployeeTypeMenuItem.BACK);
                                break;
                            }
                            case BACK: {
                                break;
                            }
                            default: {
                                view.showErrorMessage("Invalid choice. Try again.");
                            }
                        }
                    } while (adminMenuChoice != View.AdminMenuItem.BACK);
                    break;
                }
                case RECEPTION_SUB_MENU: {
                    View.ReceptionMenuItem receptionMenuItemChoice;
                    do {
                        view.showMenu(View.ReceptionMenuItem.values());
                        receptionMenuItemChoice = view.inputMenuChoice(View.ReceptionMenuItem.values());
                        switch (receptionMenuItemChoice) {
                            case ROOMS: {
                                View.RoomsMenuItem roomsMenuItemChoice;
                                do {
                                    //TODO: implement more options
                                    view.showMenu(View.RoomsMenuItem.values());
                                    roomsMenuItemChoice = view.inputMenuChoice(View.RoomsMenuItem.values());
                                    switch (roomsMenuItemChoice) {
                                        case SHOW_ALL_ROOMS: {
                                            showAllRooms();
                                            break;
                                        }
                                        case BACK: {
                                            break;
                                        }
                                        default: {
                                            view.showErrorMessage("Invalid choice. Try again.");
                                        }
                                    }
                                } while (roomsMenuItemChoice != View.RoomsMenuItem.BACK);
                                break;
                            }
                            case GUESTS: {
                                view.showMessage("Guest options coming soon.");
                                //TODO: implement
                                break;
                            }
                            case BACK: {
                                break;
                            }
                            default: {
                                view.showErrorMessage("Invalid choice. Try again.");
                            }
                        }
                    } while (receptionMenuItemChoice != View.ReceptionMenuItem.BACK);
                    break;
                }
                case LOAD: {
                    loadPreviousSession();
                    break;
                }
                case HELP: {
                    view.showMessage("Help menu coming soon.");
                    break; //TODO: implement
                }
                case QUIT: {
                    shutDownSequence();
                    break;
                }
                default: {
                    view.showErrorMessage("Invalid choice. Try again.");
                }
            }
        } while (mainMenuChoice != View.MainMenuItem.QUIT);
    }

    private void hireEmployee(Employee employee) {
        if (employee != null) {
            employees.add(employee);
            view.showMessage("Employee added.");
        }
    }

    private void dismissEmployee(int employeeID) {
        for (Employee employee :
                employees) {
            if (employeeID == employee.getEmployeeID()) {
                employees.remove(employee);
                view.showMessage("Employee dismissed.");
                return;
            }
        }
        view.showErrorMessage("No employee with that ID.");
    }

    private void showEmployees(String className) {
        Class myClass;
        try {
            myClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            view.showErrorMessage("Error showing employees.");
            return;
        }
        for (Employee employee :
                employees) {
            if (myClass.isInstance(employee)) {
                view.showElement(employee);
            }
        }
    }

    private void showAllRooms(){
        int counter = 1;
        for (Floor floor :
                floors) {
            view.showMessage("Floor " + counter + ":\n");
            counter++;
            for (Room room :
                    floor.getRooms()) {
                view.showElement(room);
            }
            view.showMessage("");
        }
    }

    private void shutDownSequence() {
        saveObjectsToFile(employeesSaveFileName, employees);
        view.showMessage("Quiting...");
        //TODO: add more files when needed
    }

    private <E> void saveObjectsToFile(String filename, E object) {
        FileUtils.writeObject(filename, object, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    private void loadPreviousSession() {
        if (view.isConfirmed("Your data may be overwritten.")) {
            employees = (ArrayList<Employee>) FileUtils.readObject(employeesSaveFileName);
        }
        //TODO: add more files when needed
    }
}
