package com.example.address_book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//AddressBookMain class
public class AddressBookMainUC5 {
	// AddressBook has a list of contacts
	static Map<String, Object> contacts;
	static int CONTACT_ID = 1;

	public static void main(String[] args) {

		final int ADD = 1;
		final int EDIT = 2;
		final int DELETE = 3;
		final int BULK_ADD = 4;

		contacts = new HashMap<>();
		// Adding contacts to address-book each with a unique id

		Scanner sc = new Scanner(System.in);
		int inputOption;

		boolean flag = true;
		while (flag) {
			System.out.println("Enter the option[1-ADD, 0-EXIT]:");
			inputOption = sc.nextInt();
			switch (inputOption) {
			case ADD:
				Contacts contact = addContact(sc, contacts);
				contacts.put(contact.getFirstName().toLowerCase() + contact.getLastName().toLowerCase()
						+ contact.getAdhaarNumber(), contact);
				System.out.println("SuccessFully Added");
				System.out.println();
				break;
			case EDIT:
				editContact(sc, contacts);
				break;
			case DELETE:
				deleteContact(sc, contacts);
				break;
			case BULK_ADD:
				bulkAddContacts(sc, contacts);
				break;
			default:
				flag = false;
				break;
			}
		}

		// Print the addressBook
		System.out.println(contacts.toString());

	}

	public static Contacts addContact(Scanner sc, Map<String, Object> contacts) {
		Contacts contact = new Contacts();

		// Take user-input
		System.out.println("Enter the firstName:");
		contact.setFirstName(sc.next().trim());
		System.out.println("Enter the lastName:");
		contact.setLastName(sc.next().trim());
		System.out.println("Enter the Address:");
		contact.setAddress(sc.next().trim());
		System.out.println("Enter the city:");
		contact.setCity(sc.next().trim());
		System.out.println("Enter the state:");
		contact.setState(sc.next().trim());
		System.out.println("Enter the zipcode:");
		contact.setZip(sc.next().trim());
		System.out.println("Enter the Adhaar number:");
		contact.setAdhaarNumber(sc.next().trim());

		System.out.println("How many Numbers you want to insert");
		int count = sc.nextInt();
		if (count > 0) {
			System.out.println("Enter the numbers followed by a new line for each number");
			List<String> mobNo = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				mobNo.add(sc.next().trim());
			}
			contact.setMobNo(mobNo);
		}

		System.out.println("How many emailIds you want to insert");
		count = sc.nextInt();
		if (count > 0) {
			System.out.println("Enter the emailIds followed by a new line for each emailId");
			List<String> email = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				email.add(sc.next().trim());
			}
			contact.setEmailId(email);
		}
		contact.setId(CONTACT_ID++);
		// Add to addressBook
		return contact;
	}

	public static void editContact(Scanner sc, Map<String, Object> contacts) {
		String input = "";
		System.out.println("Enter the firstName:");
		input += sc.next().toLowerCase().trim();
		System.out.println("Enter the lastName:");
		input += sc.next().toLowerCase().trim();
		System.out.println("Enter the Adhaar number:");
		input += sc.next().trim();
		// Check if the key exists if so take the whole input from user all-over
		if (contacts.containsKey(input)) {
			Contacts newCon = addContact(sc, contacts);
			String comparingString = newCon.getFirstName().toLowerCase() + newCon.getLastName().toLowerCase()
					+ newCon.getAdhaarNumber();
			// check if the new data added matches with existing key if yes then edit the
			// value part else add the object and delete the previous key object
			if (contacts.containsKey(comparingString)) {
				contacts.put(comparingString, newCon);
			} else {
				contacts.remove(input);
				contacts.put(comparingString, newCon);
			}
			System.out.println("SuccessFully Added");
		} else
			System.out.println("No contact found!!");
		System.out.println();
	}

	public static void deleteContact(Scanner sc, Map<String, Object> contacts) {
		String input = "";
		System.out.println("Enter the firstName:");
		input += sc.next().toLowerCase().trim();
		System.out.println("Enter the lastName:");
		input += sc.next().toLowerCase().trim();
		System.out.println("Enter the Adhaar number:");
		input += sc.next().trim();
		// Check if the key exists if so take the whole input from user all-over
		if (contacts.containsKey(input)) {
			contacts.remove(input);
			System.out.println("SuccessFully Deleted");
		} else
			System.out.println("No contact found!!");
		System.out.println();
	}

	public static void bulkAddContacts(Scanner sc, Map<String, Object> contacts) {
		System.out.println("How many Contacts you want to insert");
		int count = sc.nextInt();
		if (count > 0) {
			for (int i = 0; i < count; i++) {
				System.out.println("Enter the contact details for person " + (i + 1));
				Contacts contact = addContact(sc, contacts);
				contacts.put(contact.getFirstName().toLowerCase() + contact.getLastName().toLowerCase()
						+ contact.getAdhaarNumber(), contact);
			}
			System.out.println("Successfully Added " + count + " Contacts");
		}
	}
}
