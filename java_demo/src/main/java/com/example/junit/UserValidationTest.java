package com.example.junit;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.example.junit.services.UserService;

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

	@Before
	public void init() {
		userService = new UserService();
	}

	@Parameters
	public static Collection<?> input() {
		return Arrays.asList(
				new Object[][] { { "Harshit", "Chheda", "91 7666704112", "harshit.chheda@yahoo.com", "Harshit05#" } });
	}

	@Test
	public void testFirstNameTest() {
		assertTrue(userService.validateFirstName(firstName));
	}

	@Test
	public void testLastNameTest() {
		assertTrue(userService.validateLastName(lastName));
	}

	@Test
	public void testMobileTest() {
		assertTrue(userService.validateMobile(mobNo));
	}

	@Test
	public void testEmailTest() {
		assertTrue(userService.validateEmail(emailId));
	}

	@Test
	public void testPasswordTest() {
		assertTrue(userService.validatePassword(password));
	}
}
