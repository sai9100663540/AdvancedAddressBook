package com.bridgelabz.advancedaddressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class AddressBookMain {

    static HashMap<String,AddressBook> addressBookMap=new HashMap<>();
    static HashMap<String,ArrayList<Contact>> addressBookNames= new HashMap<String,ArrayList<Contact>>();
    public static void main(String[] args) {
        AddressBook Book = new AddressBook();
        System.out.println("Welcome in AddressBook system");
        Scanner scanner = new Scanner(System.in);
        int operation;
        do {
            System.out.println("1. ADD CONTACT " +
                    "\n2. DISPLAY All  AddressBooks  " +
                    "\n3 Search information of addressBook  " +
                    "\n4 delete contact in Address Books " +
                    "\n5 Display  Address Book"+
                    "\n6 Add new Address Book"+
                    "\n7. EXIT " );


            System.out.println("Enter the Operation Number");
            operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    scanner.nextLine();
                    if(addressBookNames.isEmpty()){
                        System.out.println("Creating your New Address Book ");
                        System.out.println("Enter a address book Name");
                        String firstName3 = scanner.nextLine();
                        addressBookNames.put(firstName3,Book.createNewAddressBook());
                    }
                    System.out.println("your Address Book Names");
                    for (String addressBookName : addressBookNames.keySet()){
                        System.out.println(addressBookName);
                    }
                    System.out.println("Choice one upper address Book name");
                    String firstName = scanner.nextLine();
                    addressBookNames.put(firstName,Book.addContact(addressBookNames.get(firstName)));
                    break;
                case 2:
                    for (Map.Entry<String, AddressBook> set : addressBookMap.entrySet()) {
                        System.out.println(set.getKey() + "=" + set.getValue());
                    }
                    break;
                case 3:
                    Book.searchPerson(addressBookNames);
                    break;
                case 4:
                    String addressBook = scanner.nextLine();
                    Book.deleteContact();
                    break;
                case 5:
                    if(addressBookNames.isEmpty()){
                        System.out.println("Address Book is empty !");
                    }
                    System.out.println("Choice your Address Book Name you want to print ");
                    for (String addressBookName : addressBookNames.keySet()){
                        System.out.println(addressBookName);
                    }
                    scanner.nextLine();
                    String firstName1 = scanner.nextLine();
                    Book.displayMyAddressBook(addressBookNames.get(firstName1));
                    break;
                case 6:
                    System.out.println("Enter a address book Name");
                    scanner.nextLine();
                    String firstName2 = scanner.nextLine();
                    addressBookNames.put(firstName2,Book.createNewAddressBook());
                    break;
                case 7:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Enter The Wrong Operation Number");
            }
        } while (operation != 7);
        Book.addAddressBookMap(Book);

    }

}
