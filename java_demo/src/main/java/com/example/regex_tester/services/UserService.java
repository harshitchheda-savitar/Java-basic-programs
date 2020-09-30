package com.example.regex_tester.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.regex_tester.models.User;

public class UserService {

	// At-least one upper-case character and minimum length of first-name is 3
	static final String FIRST_NAME_REGEX = "^[A-Z][a-zA-Z]{2,}$";
	// At-least one upper-case character and minimum length of last-name is 3
	static final String LAST_NAME_REGEX = "^[A-Z][a-zA-Z]{2,}$";
	// isd-code of the most 3 digits followed by space and then by 10-digit mobile
	// number
	static final String MOBILE_REGEX = "^[1-9][0-9]{1,2}(\\s)[1-9][0-9]{9}$";
	// user-name part followed by option part(. and then second user-name part)
	// followed by @ symbol and then by domain then . and then co-domain and then by
	// optional part(. and then inner domain)
	static final String EMAIL_REGEX = "^[a-zA-Z0-9]+([\\. | \\- | \\_]{1}[A-Za-z0-9]+)*(@){1}[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[A-Za-z]{2,})?$";
	// minimum length of password is 8
	static final String PASSWORD_LENGTH = "^.{8,}$";
	// At-least one upper-case character in password
	static final String PASSWORD_UPPER_CASE = "^.*[A-Z]{1,}.*$";
	// At-least one digit in password
	static final String PASSWORD_DIGIT = "^.*\\d{1,}.*$";
	// One mandatory special character in password
	static final String PASSWORD_SPECIAL_CHAR = "^[a-zA-Z0-9]*[^a-zA-Z0-9]{1}[a-zA-Z0-9]*$";

	public void validateDetails(User user) {

		// Validate user details
		validateFirstName(user.getFirstName());
		validateLastName(user.getLastName());
		validateMobile(user.getMobNo());
		validateEmail(user.getEmailId());
		validatePassword(user.getPassword());
	}

	private void validateFirstName(String firstName) {
		Matcher matcher = Pattern.compile(FIRST_NAME_REGEX).matcher(firstName);
		System.out.println("FirstName  criteria :" + (matcher.matches() ? "matches" : "does not match"));
	}

	private void validateLastName(String lastName) {
		Matcher matcher = Pattern.compile(LAST_NAME_REGEX).matcher(lastName);
		System.out.println("LastName  criteria :" + (matcher.matches() ? "matches" : "does not match"));
	}

	private void validateMobile(String mobNo) {
		Matcher matcher = Pattern.compile(MOBILE_REGEX).matcher(mobNo);
		System.out.println("mobileNumber criteria :" + (matcher.matches() ? "matches" : "does not match"));
	}

	private void validateEmail(String email) {
		Matcher matcher = Pattern.compile(EMAIL_REGEX).matcher(email);
		System.out.println("Email  criteria :" + (matcher.matches() ? "matches" : "does not match"));
	}

	private void validatePassword(String password) {
		passwdLengthValidate(password);
		passwdUpperCharValidate(password);
		passwdDigitValidate(password);
		passwdSpecialCharValidate(password);
	}

	private void passwdLengthValidate(String passwd) {
		Matcher matcher = Pattern.compile(PASSWORD_LENGTH).matcher(passwd);
		System.out.println("Password length :" + (matcher.matches() ? "matches" : "does not match"));
	}

	private void passwdUpperCharValidate(String passwd) {
		Matcher matcher = Pattern.compile(PASSWORD_UPPER_CASE).matcher(passwd);
		System.out.println("Password Upper Character criteria :" + (matcher.matches() ? "matches" : "does not match"));
	}

	private void passwdDigitValidate(String passwd) {
		Matcher matcher = Pattern.compile(PASSWORD_DIGIT).matcher(passwd);
		System.out.println("Password Digit criteria :" + (matcher.matches() ? "matches" : "does not match"));
	}

	private void passwdSpecialCharValidate(String passwd) {
		Matcher matcher = Pattern.compile(PASSWORD_SPECIAL_CHAR).matcher(passwd);
		System.out.println("Passwd Special character criteria :" + (matcher.matches() ? "matches" : "does not match"));
	}
}
