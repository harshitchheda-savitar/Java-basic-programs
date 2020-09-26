package com.example.address_book;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.example.address_book.models.AddressBook;
import com.example.address_book.models.Contacts;
import com.example.address_book.services.AddressBookService;

//AddressBookMain class
public class AddressBookMainUC6 {

	static final int ADD = 1;
	static final int EDIT = 2;
	static final int DELETE = 3;
	static final int BULK_ADD = 4;
	static final int ADD_ADDRESSBOOK = 5;

	public static void main(String[] args) {

		AddressBookService addressBookService = new AddressBookService();

		// initialize an address-book
		AddressBook addressBook = new AddressBook();
		addressBookService.initializeAddressBook(addressBook);

		Map<String, AddressBook> addressBookMap = new HashMap<>();

		Scanner sc = new Scanner(System.in);
		int inputOption;

		boolean flag = true;
		while (flag) {
			System.out
					.println("Enter the option[1-ADD, 2-EDIT , 3-DELETE, 4-BULK-ADD, 5-SAVE_ADD_ADDRESSBOOK, 0-EXIT]:");
			inputOption = sc.nextInt();
			switch (inputOption) {
			case ADD:
				Contacts contact = addressBookService.getDetails(sc, addressBook);
				addressBookService.addContacts(addressBook, contact);
				System.out.println("SuccessFully Added!!!!!");
				System.out.println();
				break;
			case EDIT:
				String searchString = addressBookService.searchForContact(sc, addressBook);
				if (searchString != null) {
					contact = addressBookService.getDetails(sc, addressBook);
					addressBookService.editContacts(searchString, addressBook, contact);
				}
				System.out.println("SuccessFully Edited!!!");
				System.out.println();
				break;
			case DELETE:
				searchString = addressBookService.searchForContact(sc, addressBook);
				if (searchString != null) {
					addressBookService.deleteContacts(searchString, addressBook);
				}
				System.out.println("SuccessFully Deleted!!!");
				System.out.println();
				break;
			case BULK_ADD:
				addressBookService.bulkAddContacts(sc, addressBook);
				break;
			case ADD_ADDRESSBOOK:
				flag = addressBookService.addMultipleBooks(sc, addressBookMap, addressBook);
				break;
			default:
				flag = false;
				break;
			}
		}

		// Print the addressBookMap

	}

}
