package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locatorExample {

	public static void main(String[] args) {
		
		
		
			 WebDriver driver = new ChromeDriver();
             driver.get("https://demoblaze.com/");
             
            // driver.findElement(By.name("search")).sendKeys("iPhone");
             
            // boolean logoDisplay = driver.findElement(By.id("logo")).isDisplayed();
            // System.out.println(logoDisplay);
            
             driver.findElement(By.linkText("Log in")).click();
             driver.findElement(By.cssSelector("input[type='text']")).sendKeys("testusername");
            // List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
            // System.out.println(headerLinks.size());
             
           //  List<WebElement> imageNumber = driver.findElements(By.tagName("img"));
            // System.out.println(imageNumber.size());
             
             
           //  List<WebElement> imageNumber = driver.findElements(By.tagName("a"));
            // System.out.println(imageNumber.size());
	       //  driver.findElement(By.linkText("Samsung galaxy s6")).click();
	           
	}
	
	

}
