package day9;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class orangehrm {
WebDriver driver;
	@BeforeClass
	void openApp() {
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority = 1)
	void logoStatus() throws InterruptedException {
		Thread.sleep(2000);
		Boolean status =driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("logo status "+status);
	}
	
	@Test 
	void testUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@Test(priority = 2,dependsOnMethods = "testUrl")
	void login() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("amin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		if(driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}
	
	
	@Test(priority = 3,dependsOnMethods = "login")
	void selectHiddenDrop() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div[2]/div[3]")).click();
        
	}
	@AfterClass
	void closeApp() {
		driver.quit();
	}
}
