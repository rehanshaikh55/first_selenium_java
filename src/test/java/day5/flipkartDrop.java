package day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class flipkartDrop {

	public static void main(String[] args) {
WebDriver driver = new ChromeDriver();
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://flipkart.com");
				driver.manage().window().maximize();
				WebElement elementToHover = driver.findElement(By.xpath("//div[@aria-label='Fashion']"));
				Actions actions = new Actions(driver);
	            // Perform the hover action
	            actions.moveToElement(elementToHover).perform();
	            WebElement submenu = driver.findElement(By.linkText("Men's T-Shirts"));
	            submenu.click();
	            
	            driver.navigate().back();
	            
	            Actions act = new Actions(driver);
	            
	            act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
	           

	}

}
