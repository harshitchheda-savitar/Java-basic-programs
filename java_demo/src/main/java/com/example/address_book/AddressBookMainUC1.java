package com.example.address_book;

import com.example.address_book.models.AddressBook;
import com.example.address_book.models.Contacts;
import com.example.address_book.services.AddressBookService;

//AddressBookMain class
public class AddressBookMainUC1 {

	public static void main(String[] args) {

		AddressBookService addressBookService = new AddressBookService();

		// initialize an address-book
		AddressBook addressBook = new AddressBook();
		addressBookService.initializeAddressBook(addressBook);

		// Get details for the contact
		Contacts contact = new Contacts();
		contact.setFirstName("harshit");
		contact.setLastName("chheda");
		contact.setAddress("somewhere");
		contact.setCity("Mumbai");
		contact.setState("Maharashtra");
		contact.setZip("101010");
		contact.setAdhaarNumber("123512341234");

		// Add contact
		addressBookService.addContacts(addressBook, contact);

		// Print the addressBook
		addressBookService.displayAddressBook(addressBook);

	}
}
