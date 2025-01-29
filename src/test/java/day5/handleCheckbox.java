package day5;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class handleCheckbox {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		/*for(int i=0;i<checkboxList.size();i++) {
			checkboxList.get(i).click();
		}*/
       /* for(WebElement checkbox:checkboxList) {
        	checkbox.click();
        }*/
        for(int i=4;i<checkboxList.size();i++) {
			checkboxList.get(i).click();
		}
	
	}

}
