package com.example.address_book.models;

import java.util.Map;

/**
 * @author harsh - address-book model
 *
 */
public class AddressBook {

	private Map<String, Contacts> contacts;

	public Map<String, Contacts> getContacts() {
		return contacts;
	}

	public void setContacts(Map<String, Contacts> contacts) {
		this.contacts = contacts;
	}

}
