package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean quit = false;
        MobilePhone mobilePhone = new MobilePhone();
        printOptions();
        while(!quit) {
            System.out.println("Please enter the number: ");
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case 0:
                    printOptions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    Contact newContact = createContact();
                    mobilePhone.addContact(newContact);
                    break;
                case 3:
                    int position = specifyContactPosition();
                    Contact updatedContact = createContact();
                    mobilePhone.updateExistingContact(position, updatedContact);
                    break;
                case 4:
                    int removalPosition = specifyContactPosition();
                    mobilePhone.removeContact(removalPosition);
                    break;
                case 5:
                    Contact searchContact = createContact();
                    mobilePhone.searchForContact(searchContact);
                    break;
                case 6:
                    quit = true;
            }
        }
    }

    public static void printOptions() {
        System.out.println("\nPress");
        System.out.println("\t0 - To print choice options.");
        System.out.println("\t1 - To print the list of contacts.");
        System.out.println("\t2 - To add a contact to the list.");
        System.out.println("\t3 - To modify a contact in the list");
        System.out.println("\t4 - To remove a contact from the list");
        System.out.println("\t5 - To search for the item in the list");
        System.out.println("\t6 - To quit the application");
    }

    public static Contact createContact() {
        System.out.println("Please specify the name for the contact: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Please specify the number for the contact");
        String phoneNumber = scanner.nextLine();
        scanner.nextLine();
        return new Contact(name, phoneNumber);
    }

    public static int specifyContactPosition() {
        System.out.println("Please specify the position of the contact: ");
        int position = scanner.nextInt() - 1;
        scanner.nextLine();
        return position;
    }
}
