package com.example.junit_cases;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.example.junit_cases.services.UserService;

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
		return Arrays.asList(new Object[][] { { "abc@yahoo.com", true }, { "abc-100@yahoo.com", true },
				{ "abc.100@yahoo.com", true }, { "abc111@abc.com", true }, { "abc-100@abc.net", true },
				{ "abc.100@abc.com.au", true }, { "abc@1.com", true }, { "abc@gmail.com.com", true },
				{ "abc-100@abc.net", true }, { "abc", false }, { "abc+100@gmail.com", false }, { "abc@.com.my", false },
				{ "abc123@gmail.a", false }, { "abc123@.com", false }, { "abc123@.com.com", false },
				{ ".abc@abc.com", false }, { "abc()*@gmail.com", false }, { "abc@%*.com", false },
				{ "abc..2002@gmail.com", false }, { "abc.@gmail.com", false }, { "abc@abc@gmail.com", false },
				{ "abc@gmail.com.1a", false }, { "abc@gmail.com.aa.au", false }, });
	}

	@Test
	public void emailCreteriaTest() {
		assertEquals(userService.validateEmail(emailId), expectedResult);
	}
}
