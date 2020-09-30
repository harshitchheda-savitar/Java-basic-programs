package com.example.custom_exception;

import java.util.Scanner;

import com.example.custom_exception.exceptions.UserValidationException;
import com.example.custom_exception.models.User;
import com.example.custom_exception.services.UserService;

public class UserExceptionMain {

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

		try {
			userService.validateDetails(user);
		} catch (UserValidationException e) {
			System.out.println(e.getClass() + ":" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
