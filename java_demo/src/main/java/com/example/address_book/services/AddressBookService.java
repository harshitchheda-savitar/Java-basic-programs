package com.example.address_book.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.example.address_book.interfaces.AddressBookInterface;
import com.example.address_book.models.AddressBook;
import com.example.address_book.models.Contacts;

public class AddressBookService implements AddressBookInterface {

	@Override
	public void initializeAddressBook(AddressBook addressBook) {
		addressBook.setContacts(new HashMap<>());
	}

	@Override
	public void addContacts(AddressBook addressBook, Contacts contact) {
		Map<String, Contacts> contacts = addressBook.getContacts();
		contacts.put(
				contact.getFirstName().toLowerCase() + contact.getLastName().toLowerCase() + contact.getAdhaarNumber(),
				contact);
		addressBook.setContacts(contacts);
	}

	@Override
	public void editContacts(String searchString, AddressBook addressBook, Contacts contact) {

		Map<String, Contacts> contacts = addressBook.getContacts();

		String comparingString = contact.getFirstName().toLowerCase() + contact.getLastName().toLowerCase()
				+ contact.getAdhaarNumber();
		// check if the new data added matches with existing key if yes then edit the
		// value part else add the object and delete the previous key object
		if (searchString.equals(comparingString)) {
			contacts.put(comparingString, contact);
		} else {
			contacts.remove(searchString);
			contacts.put(comparingString, contact);
		}

		addressBook.setContacts(contacts);
	}

	@Override
	public void deleteContacts(String searchString, AddressBook addressBook) {
		Map<String, Contacts> contacts = addressBook.getContacts();
		contacts.remove(searchString);
		addressBook.setContacts(contacts);
	}

	@Override
	public void addMultipleBooks() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayAddressBook(AddressBook addressBook) {
		System.out.println(addressBook.getContacts().toString());
	}

	public String searchForContact(final Scanner sc, AddressBook addressBook) {
		Map<String, Contacts> contacts = addressBook.getContacts();

		String input = "";
		System.out.println("Enter the firstName:");
		input += sc.next().toLowerCase().trim();
		System.out.println("Enter the lastName:");
		input += sc.next().toLowerCase().trim();
		System.out.println("Enter the Adhaar number:");
		input += sc.next().trim();

		// Check if the key exists if so take the whole input from user all-over
		if (contacts.containsKey(input)) {
			System.out.println("found contact matching your search!!");
			return input;
		} else {
			System.out.println("No contact found!!");
			return null;
		}

	}

	public Contacts getDetails(final Scanner sc, AddressBook addressBook) {
		Contacts contact = new Contacts();

		// Take user-input
		System.out.println("Enter the firstName:");
		contact.setFirstName(sc.next().trim());
		System.out.println("Enter the lastName:");
		contact.setLastName(sc.next().trim());
		System.out.println("Enter the Adhaar number:");
		contact.setAdhaarNumber(sc.next().trim());
		System.out.println("Enter the Address:");
		contact.setAddress(sc.next().trim());
		System.out.println("Enter the city:");
		contact.setCity(sc.next().trim());
		System.out.println("Enter the state:");
		contact.setState(sc.next().trim());
		System.out.println("Enter the zipcode:");
		contact.setZip(sc.next().trim());

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
		return contact;
	}

	public void bulkAddContacts(final Scanner sc, AddressBook addressBook) {
		System.out.println("How many Contacts you want to insert");
		int count = sc.nextInt();
		if (count > 0) {
			for (int i = 0; i < count; i++) {
				System.out.println("Enter the contact details for person " + (i + 1));
				Contacts contact = getDetails(sc, addressBook);
				addContacts(addressBook, contact);
			}
			System.out.println("Successfully Added " + count + " Contacts");
			System.out.println();
		}
	}

}
