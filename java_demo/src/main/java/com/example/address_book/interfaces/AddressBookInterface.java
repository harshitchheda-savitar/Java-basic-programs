package com.example.address_book.interfaces;

import com.example.address_book.models.AddressBook;
import com.example.address_book.models.Contacts;

/**
 * @author harsh - address-book methods
 */
public interface AddressBookInterface {

	public void initializeAddressBook(AddressBook addressBook);

	public void addContacts(AddressBook addressBook, Contacts contact);

	public void editContacts(String serachString, AddressBook addressBook, Contacts contact);

	public void deleteContacts(String searchString, AddressBook addressBook);

	public void displayAddressBook(AddressBook addressBook);
}
