package day5;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handleAlertwithExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		Thread.sleep(2000);
		
		Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
		myAlert.sendKeys("Rehan");
		myAlert.accept();
	}

}
