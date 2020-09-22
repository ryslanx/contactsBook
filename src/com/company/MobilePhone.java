package com.company;

import java.util.ArrayList;

public class MobilePhone {
    ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        if (checkIfNameExists(contact)) {
            System.out.println("Sorry, this name already exists. Please choose another name.");
        } else {
            contacts.add(contact);
        }
    }

    public void printContacts() {
        if (this.contacts.size() == 0) {
            System.out.println("Unfortunately, you haven't added any contacts yet.");
        } else {
            for (int i = 0; i < this.contacts.size(); i++) {
                System.out.println("The #" + (i + 1) + " item");
                System.out.println("The name of the contact is " + contacts.get(i).getName());
                System.out.println("The phone number of the contact is " + contacts.get(i).getPhoneNumber() + "\n\n");
            }
        }

    }

    private void printInvalidIndexMessage() {
        System.out.println("Sorry, this index is invalid. Please specify another index.");
    }

    public void updateExistingContact(int position, Contact newContact) {
        if (checkValidIndex(position) || !checkIfNameExists(newContact)) {
            printInvalidIndexMessage();
        } else {
            contacts.set(position, newContact);
        }
    }

    private boolean checkValidIndex(int position) {
        return position >= this.contacts.size() || position < 0;
    }

    private boolean checkIfNameExists(Contact contact) {
        for (int i = 0; i < this.contacts.size(); i++) {
            if (contacts.get(i).getName().equals(contact.getName())) {
                return true;
            }
        }
        return false;
    }

    public void removeContact(int position) {
        if (checkValidIndex(position)) {
            printInvalidIndexMessage();
        } else {
            contacts.remove(position);
        }
    }

    public Contact searchForContact(Contact contact) {
        int position = contacts.indexOf(contact);
        if (position >= 0) {
            return contacts.get(position);
        }
        return null;
    }



}
