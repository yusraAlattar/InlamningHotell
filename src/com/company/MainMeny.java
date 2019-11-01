package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.Main.myScan;

public class MainMeny {

    static int userChoice;

    ArrayList<Person> persons;
    private boolean isRunning = true;

    public MainMeny() {
        persons = (ArrayList<Person>) FileUtility.loadObject("person.ser");
        if (persons == null) {
            persons = new ArrayList<>();
        }
    ArrayList<String>employees = new ArrayList<>();
        employees.add("Anna Eriksson");
        employees.add("David Eriksson");
        employees.add("Josef Eriksson");
    }

    public void printHeader() {
        System.out.println("----------------------------------------");
        System.out.println("|             WELCOME TO                 |");
        System.out.println("|         ** Hotel Heavenly **           |");
        System.out.println("----------------------------------------");
    }

    public void printMenu() {
        System.out.println("Please make a selection:\n" +
                "1. Book a room\n" +
                "2. Remove my booking\n" +
                "3. Show my personal booking\n" +
                "4. For our employeers only: Show all bookings and customers\n" +
                "5. Help\n" +
                "6. Exit \n" +
                "7. Show Employees  \n" +
                "8. Check-in hours");
    }

    public void getFirstChoice() {

        int userchoice = 0;
        do {
            printMenu();
            userChoice = MiscUtility.getIntegerFromString();
            switch (userChoice) {
                case 1:
                    System.out.println("------------------------------------------------------------------------------");
                    makeBooking();
                    break;
                case 2:
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("please enter your name to remove your booking");
                    removeName(persons);//metoden körs i classen services eftersom persons finns endast här
                    break;
                case 3:
                    System.out.println("------------------------------------------------------------------------------");
                    findName();
                    break;
                case 4:
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Name of guest ||" + "" + " " + "phone number of guest ||" + "" + "" + "Room type ||" + "" + "Number of nights ");
                    for (Person person : persons) {
                        System.out.println(person.getName() + "            " + person.getPhone() + "                    " + person.getRoomChoice() + "             " + person.getNumberOfNights());
                        System.out.println("..........................................................................");
                    }
                    break;
                case 5:
                    System.out.println("---------------------------------------------------------------------------------\n" +
                            "If you need to come in contact with us, here is our contact information:\n" +
                            "Email: HH@hh.com,\n" +
                            "Phone number: +00 112 23 344,\n" +
                            "Adress: HH street 56,\n---------------------------------------------------------------------------------");
                    break;
                case 6:
                    isRunning = false;
                    break;

case 7:

    Services s = new Services();
    s.employeesList();
         break;
                case 8:

                    Room infoSingle = new SingleRoom();
                    infoSingle.showInfo();
                    Room infoDouble = new DoubleRoom();
                    infoDouble.showInfo();
                    Room infoSuit = new Suit();
                    infoSuit.showInfo();

            }

        } while (isRunning);

    }

    private void findName() {

        System.out.println("Write your name so wbe can find your booking in our system please! ");
        String name = Main.myScan.nextLine();
        boolean hasFoundAMatchingName = false;

        for (Person p : persons) {
            if (p.getName().equals(name)) {
                hasFoundAMatchingName = true;
                String roomType = "";


                if (p.getRoomChoice() == 1) {
                    roomType = "single room";
                } else if (p.getRoomChoice() == 2) {
                    roomType = "Double room";
                } else if (p.getRoomChoice() == 3) {
                    roomType = "Suit";
                }

                System.out.println("Booking information\n" +
                        "Name: " + p.getName() + "\n" +
                        "Phone number: " + p.getPhone() + "\n" +
                        "Roomtype: " + roomType + "\n" +
                        "Number of nights: " + p.getNumberOfNights() + " nights");
            }
        }
        if (hasFoundAMatchingName == false) {
            System.out.println("We could not find any booking with the given name, please try again or make another choice! ");
        }
    }

    /**
     * This method let the user make a booking in the hotels booking system. You get som choices
     * and after your first choice in this method you will be asked to cconfirm if you wish
     * to book or to go back to main meny. By pressing 1 you will be able to make the
     * booking by giving your personal information.
     */
    private void makeBooking() {
        System.out.println("What kind of room do you wish to book,\n" +
                "please make one of those coming selections:\n" +
                "1. Single Room\n" +
                "2. Double Room\n" +
                "3. Suit");

        int roomChoice = MiscUtility.getIntegerFromString();
        Room room = getRoom(roomChoice);
        room.printRoomAdvantages();


        int bookingApprovemet = 0;
        while (bookingApprovemet != 6) {
            System.out.println("If you want to book this room please press 1 or press 2 to go back to the menu.");
            bookingApprovemet = MiscUtility.getIntegerFromString();

            switch (bookingApprovemet) {
                case 1:
                    System.out.println("please enter your name: ");
                    String name = myScan.nextLine();
                    System.out.println("please enter your phone number: ");
                    String number = myScan.nextLine();
                    System.out.println("Please enter the number of nights you wish to stay in out hotel: ");
                    int numberOfNights = MiscUtility.getIntegerFromString();

                    System.out.println("Thank you " + name + "!" + " This is a confirmation that you have booked a " + room.info + "for " + numberOfNights + " nights");
                    System.out.println("The total cost for your stay is: " + room.roomPrice * numberOfNights);
                    addPerson(name, number, roomChoice, numberOfNights);
                    return;
                case 2:
                    return;
            }
        }

    }


    public Room getRoom(int roomChoice) {

        switch (roomChoice) {
            case 1:
                return new SingleRoom();

            case 2:
                return new DoubleRoom();

            case 3:
                return new Suit();

            default:
                return null;
        }
    }

    void addPerson(String name, String number, int roomChoice, int numberOfNights) {//test
        Person perspnObj = new Person(name, number, roomChoice, numberOfNights);
        persons.add(perspnObj);
    }

    public void save() {
        FileUtility.saveObject("person.ser", persons);
    }

    public static void removeName(ArrayList<Person> personsToRemoveFrom) {

        String name = Main.myScan.nextLine();


        for (Person p : personsToRemoveFrom) {
            if (p.getName().equals(name)) {
                System.out.println(p.getName() + " has been removed");
                personsToRemoveFrom.remove(p);
                System.out.println("Your booking was successfully deleted!");
                FileUtility.saveObject("person.ser", personsToRemoveFrom);
                return;
            }
        }
        System.out.println("Sorry but we could not find your booking! ");
    }

}