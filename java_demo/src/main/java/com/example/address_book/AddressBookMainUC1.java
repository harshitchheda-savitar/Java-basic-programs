package com.example.address_book;

import java.util.ArrayList;
import java.util.List;

//AddressBookMain class
public class AddressBookMainUC1 {

	public static final int MAX_COUNT = 5;

	public static void main(String[] args) {

		List<Contacts> contacts = new ArrayList<>();

		// Adding contacts to address-book each with a unique id
		int contactId = 1;
		while (contactId <= MAX_COUNT) {
			Contacts contact = new Contacts();
			contact.setId(contactId++);
			contact.setFirstName("harshit");
			contact.setLastName("chheda");
			contact.setAddress("somewhere");
			contact.setCity("Mumbai");
			contact.setState("Maharashtra");
			contact.setZip("101010");

			contacts.add(contact);
		}

		// Print the addressBook
		System.out.println(contacts.toString());

	}
}
