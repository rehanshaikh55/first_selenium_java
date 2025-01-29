package day7;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.*;
public class handleSlider {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriver driver= new ChromeDriver();
        driver.get("https://jqueryui.com/resources/demos/slider/range.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement startPosi =driver.findElement(By.xpath("//span[1]"));
        
        System.out.println(startPosi.getLocation());
        Actions act = new Actions(driver);
        
       act.dragAndDropBy(startPosi, 500,47).perform();
       System.out.println(startPosi.getLocation());
	}

}
