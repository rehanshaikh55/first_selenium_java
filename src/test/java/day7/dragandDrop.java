package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class dragandDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
				driver.manage().window().maximize();
				
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
				//WebElement mainElement = driver.findElement(By.xpath("//li[1]"));
				WebElement targetElement= driver.findElement(By.xpath("//div[@id='trash']")); 
				
				Actions act = new Actions(driver);
				//act.dragAndDrop(mainElement, targetElement).perform();
				for(int i=1;i<=3;i++) {
					WebElement mainElement = driver.findElement(By.xpath("//li["+i+"]"));
					act.dragAndDrop(mainElement, targetElement).perform();
				}
				
	}

}
