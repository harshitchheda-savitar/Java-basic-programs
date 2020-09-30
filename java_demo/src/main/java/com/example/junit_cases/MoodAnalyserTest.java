package com.example.junit_cases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.example.junit_cases.services.UserService;

public class MoodAnalyserTest {

	private UserService userService;

	@Before
	public void init() {
		userService = new UserService();
	}

	// first-name mood analyzer
	@Test
	public void firstNamePositiveTest() {
		assertTrue(userService.validateFirstName("Harshit"));
	}

	@Test
	public void firstNameNegativeTest() {
		assertFalse(userService.validateFirstName("harsH"));
	}

	// last-name mood analyzer
	@Test
	public void lastNamePositiveTest() {
		assertTrue(userService.validateLastName("Something"));
	}

	@Test
	public void lastNameNegativeTest() {
		assertFalse(userService.validateLastName("someThi"));
	}

	// mood analyzer based on mobile number
	@Test
	public void mobilePositiveTest() {
		assertTrue(userService.validateMobile("91 1234567891"));
	}

	@Test
	public void mobileNegativeTest() {
		assertFalse(userService.validateMobile("911234657895"));
	}

	// mood analyzer based on email
	@Test
	public void emailPositiveTest() {
		assertTrue(userService.validateEmail("harshit@abc.com"));
	}

	@Test
	public void emailNegativeTest() {
		assertFalse(userService.validateEmail("abc.@yahoo.co1"));
	}

	// mood analyzer based on password
	@Test
	public void passwordPositiveTest() {
		assertTrue(userService.validatePassword("Abc#1201"));
	}

	@Test
	public void passwordNegativeTest() {
		assertFalse(userService.validatePassword("Har$$h084"));
	}
}
