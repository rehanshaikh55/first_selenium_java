package day9;

import org.testng.annotations.Test;

public class firstTestng {

	@Test(priority = 0)
	void openApp() {
		System.out.println("opening an app");
	}
	@Test(priority = 1)
	void login() {
		System.out.println("login an app");
	}
	@Test(priority = 2)
	void logout() {
		System.out.println("logout an app");
	}
	
}
