package com.example.address_book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//AddressBookMain class
public class AddressBookMainUC2 {
	// AddressBook has a list of contacts
	static List<Contacts> contacts;

	public static void main(String[] args) {

		final int ADD = 1;

		contacts = new ArrayList<>();
		// Adding contacts to address-book each with a unique id
		int contactId = 1;

		Scanner sc = new Scanner(System.in);
		int inputOption;

		boolean flag = true;
		while (flag) {
			System.out.println("Enter the option[1-ADD, 0-EXIT]:");
			inputOption = sc.nextInt();
			switch (inputOption) {
			case ADD:
				addContact(sc, contactId, contacts);
				break;
			default:
				flag = false;
				break;
			}

		}

		// Print the addressBook
		System.out.println(contacts.toString());

	}

	public static void addContact(Scanner sc, int contactId, List<Contacts> contacts) {
		Contacts contact = new Contacts();

		//Take user-input
		System.out.println("Enter the firstName:");
		contact.setFirstName(sc.next());
		System.out.println("Enter the lastName:");
		contact.setLastName(sc.next());
		System.out.println("Enter the Address:");
		contact.setAddress(sc.next());
		System.out.println("Enter the city:");
		contact.setCity(sc.next());
		System.out.println("Enter the state:");
		contact.setState(sc.next());
		System.out.println("Enter the zipcode:");
		contact.setZip(sc.next());

		System.out.println("How many Numbers you want to insert");
		int count = sc.nextInt();
		if (count > 0) {
			System.out.println("Enter the numbers followed by a new line for each number");
			List<String> mobNo = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				mobNo.add(sc.next());
			}
			contact.setMobNo(mobNo);
		}

		System.out.println("How many emailIds you want to insert");
		count = sc.nextInt();
		if (count > 0) {
			System.out.println("Enter the emailIds followed by a new line for each emailId");
			List<String> email = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				email.add(sc.next());
			}
			contact.setEmailId(email);
		}
		contact.setId(contactId++);
		//Add to addressBook
		contacts.add(contact);
		System.out.println("SuccessFully Added");
		System.out.println();
	}
}
