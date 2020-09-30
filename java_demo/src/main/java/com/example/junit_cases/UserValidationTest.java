package com.example.junit_cases;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.example.junit_cases.services.UserService;

@RunWith(Parameterized.class)
public class UserValidationTest {
	private String firstName;
	private String lastName;
	private String mobNo;
	private String emailId;
	private String password;
	private UserService userService;

	public UserValidationTest(String firstName, String lastName, String mobNo, String emailId, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNo = mobNo;
		this.emailId = emailId;
		this.password = password;
	}

	public UserValidationTest(String emailId) {
		this.emailId = emailId;
	}

	@Before
	public void init() {
		userService = new UserService();
	}

	@Parameters
	public static List<String[]> input() {
		return Arrays.asList(
				new String[][] { { "Harshit", "Chheda", "91 7666704112", "harshit.chheda@yahoo.com", "Harshit05#" } });
	}

	@Test
	public void firstNameCriteriaTest() {
		assertTrue(userService.validateFirstName(firstName));
	}

	@Test
	public void lastNameCriteriaTest() {
		assertTrue(userService.validateLastName(lastName));
	}

	@Test
	public void MobileCriteriaTest() {
		assertTrue(userService.validateMobile(mobNo));
	}

	@Test
	public void emailCriteriaTest() {
		assertTrue(userService.validateEmail(emailId));
	}

	@Test
	public void passwordCriteriaTest() {
		assertTrue(userService.validatePassword(password));
	}

}
