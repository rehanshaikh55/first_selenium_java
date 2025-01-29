package day5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class handleDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		WebElement dropdownEl = driver.findElement(By.xpath("//select[@id='country']"));
		Select countyDrop = new Select(dropdownEl);
          //countyDrop.selectByIndex(2);
		
		List<WebElement> optionList = countyDrop.getOptions();
		
		System.out.println(optionList.size());
		
		for(int i=0;i<optionList.size();i++) {
			System.out.println(optionList.get(i).getText());
		}
	}

}
