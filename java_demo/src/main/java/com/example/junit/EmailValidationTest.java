package com.example.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.example.junit.services.UserService;

@RunWith(Parameterized.class)
public class EmailValidationTest {
	private String emailId;
	private boolean expectedResult;
	private UserService userService;

	public EmailValidationTest(String emailId, boolean expectedResult) {
		this.emailId = emailId;
		this.expectedResult = expectedResult;

	}

	@Before
	public void init() {
		userService = new UserService();
	}

	@Parameters
	public static List<Object[]> input1() {
		return Arrays.asList(new Object[][] {
			{ "abc@yahoo.com", true },
			{ "abc-100@yahoo.com", true },
			{ "abc.100@yahoo.com", true },
			{ "abc", false },
			{ "abc111@abc.com", true },
			{ "abc-100@abc.net", true},
			{ "abc.100@abc.com.au", true},
			{ "abc@1.com", true},
			{ "abc@gmail.com.com", true},
			{ "abc-100@abc.net", true},
			{ "abc+100@gmail.com", false}});
	}

	@Test
	public void testEmailTest() {
		assertEquals(userService.validateEmail(emailId), expectedResult);
	}
}
