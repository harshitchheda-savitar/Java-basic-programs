package com.example.address_book;

import java.util.Scanner;

import com.example.address_book.models.AddressBook;
import com.example.address_book.models.Contacts;
import com.example.address_book.services.AddressBookService;

//AddressBookMain class
public class AddressBookMainUC2 {

	static final int ADD = 1;

	public static void main(String[] args) {

		AddressBookService addressBookService = new AddressBookService();

		// initialize an address-book
		AddressBook addressBook = new AddressBook();
		addressBookService.initializeAddressBook(addressBook);

		Scanner sc = new Scanner(System.in);
		int inputOption;

		boolean flag = true;
		while (flag) {
			System.out.println("Enter the option[1-ADD, 0-EXIT]:");
			inputOption = sc.nextInt();
			switch (inputOption) {
			case ADD:
				// get details of the contact
				Contacts contact = addressBookService.getDetails(sc, addressBook);
				// add contact to address-book
				addressBookService.addContacts(addressBook, contact);
				System.out.println("SuccessFully Added!!!!!");
				System.out.println();
				break;
			default:
				flag = false;
				break;
			}

		}

		// Print the addressBook
		addressBookService.displayAddressBook(addressBook);

	}
}
