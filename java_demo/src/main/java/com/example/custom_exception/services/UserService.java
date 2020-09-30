package com.example.custom_exception.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.custom_exception.exceptions.UserValidationException;
import com.example.custom_exception.models.User;

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
	// At-least one upper-case character in password
	// At-least one digit in password
	// One mandatory special character in password
	static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[A-Z])(?=.*\\W)(?!.*\\W\\w*\\W)(?!.*\\s).{8,}$";

	public void validateFirstName(String firstName) throws UserValidationException {
		Matcher matcher = Pattern.compile(FIRST_NAME_REGEX).matcher(firstName);
		if (!matcher.matches())
			throw new UserValidationException("FirstName does not match the criteria");
	}

	public void validateLastName(String lastName) throws UserValidationException {
		Matcher matcher = Pattern.compile(LAST_NAME_REGEX).matcher(lastName);
		if (!matcher.matches())
			throw new UserValidationException("LastName does not match the criteria");
	}

	public void validateMobile(String mobNo) throws UserValidationException {
		Matcher matcher = Pattern.compile(MOBILE_REGEX).matcher(mobNo);
		if (!matcher.matches())
			throw new UserValidationException("Mobile number does not match the criteria");
	}

	public void validateEmail(String email) throws UserValidationException {
		Matcher matcher = Pattern.compile(EMAIL_REGEX).matcher(email);
		if (!matcher.matches())
			throw new UserValidationException("Email does not match the criteria");
	}

	public void validatePassword(String password) throws UserValidationException {
		Matcher matcher = Pattern.compile(PASSWORD_REGEX).matcher(password);
		if (!matcher.matches())
			throw new UserValidationException("Password does not match the criteria");
	}

	public void validateDetails(User user) throws UserValidationException {
		validateFirstName(user.getFirstName());
		validateLastName(user.getLastName());
		validateMobile(user.getMobNo());
		validateEmail(user.getEmailId());
		validatePassword(user.getPassword());
	}
}
