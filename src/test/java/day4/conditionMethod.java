package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class conditionMethod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		WebElement male_rd = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
		WebElement female_rd = driver.findElement(By.xpath("//input[@id='gender-radio-2']"));
		
		System.out.println("before selection");
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		
		driver.findElement(By.xpath("//label[normalize-space()='Male']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[normalize-space()='Female']")).click();
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());

	}

}
