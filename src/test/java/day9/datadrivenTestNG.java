package day9;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class datadrivenTestNG {

	WebDriver driver;
	
	@BeforeClass 
	@Parameters({"browser"})
	void setup(String br) {
		switch(br.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		case "firefox" : driver= new FirefoxDriver();break;
		default: System.out.println("invailed browser");return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider = "dp")
	void testLogin(String email,String pass) throws InterruptedException {
          
        driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(1000);
		Boolean status= driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		
		if(status == true) {
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Account']")).click();
			Assert.assertTrue(true);
			
		}else {
			System.out.println("login failed");
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Login']")).click();
		Assert.fail();
		}
		
	}
	
	/*
	@Test(dataProvider = "dp")
	void forgotpass(String email,String pass) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='form-group']//a[normalize-space()='Forgotten Password']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		if(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
	}
	*/
	@AfterClass 
	void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="dp")
	Object[][] logindata(){
		Object data[][]= {
				{"rehanstest@gmail.com","test@123"},
				{"rehanstest@gmail.com","test@123"},
				{"test@gmail.com","test@123"},
				{"rehanstest@gmail.com","test@123"},
				{"rehansstest@gmail.com","test@123"},
				{"rehanstest@@gmail.com","test@123"},
		};
		return data;
	}
	
}
