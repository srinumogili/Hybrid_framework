package Testng_practice;

import org.testng.annotations.Test;

public class FirstTestcase {
	@Test(priority = 1)
	void launchtheapplication() {
		System.out.println("launch the application...");
	}

	@Test(priority = 2)
	void login() {
		System.out.println("login the application");
	}

	@Test(priority = 3)
	void logout() {
		System.out.println("logout the application");
	}
}
