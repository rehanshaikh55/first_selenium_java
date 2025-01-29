package day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleAlert {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		/*
		driver.findElement(By.xpath("//a[@id='alert']")).click();
		
		Thread.sleep(2000);
		
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.accept();
		*/
driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		Thread.sleep(2000);
		
		Alert myAlert = driver.switchTo().alert();
		myAlert.sendKeys("Rehan");
		myAlert.dismiss();
	}

}
