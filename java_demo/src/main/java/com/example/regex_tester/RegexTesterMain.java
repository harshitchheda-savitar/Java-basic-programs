package com.example.regex_tester;

import java.util.Scanner;

import com.example.regex_tester.models.User;
import com.example.regex_tester.services.UserService;

public class RegexTesterMain {

	public static void main(String[] args) {

		UserService userService = new UserService();
		Scanner sc = new Scanner(System.in);

		User user = new User();
		System.out.println("Enter the first-name: ");
		user.setFirstName(sc.nextLine().trim());
		System.out.println("Enter the last-name: ");
		user.setLastName(sc.nextLine().trim());
		System.out.println("Enter the mobile number: ");
		user.setMobNo(sc.nextLine().trim());
		System.out.println("Enter the emailId: ");
		user.setEmailId(sc.nextLine().trim());
		System.out.println("Enter the password: ");
		user.setPassword(sc.nextLine().trim());
		sc.close();

		userService.validateDetails(user);

	}
}
