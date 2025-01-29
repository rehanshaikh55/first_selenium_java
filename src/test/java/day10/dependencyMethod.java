package day10;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependencyMethod {
@Test(priority = 0)
void openapp() {
	Assert.assertTrue(false);
}
@Test(priority = 1,dependsOnMethods = "openapp")
void login() {
	Assert.assertTrue(false);
}
@Test(priority = 2,dependsOnMethods = "login")
void search() {
	Assert.assertTrue(false);
}
@Test(priority = 3,dependsOnMethods = "login")
void advsearch() {
	Assert.assertTrue(false);
}
@Test(priority = 4,dependsOnMethods = "openapp")
void logout() {
	Assert.assertTrue(false);
}
}
