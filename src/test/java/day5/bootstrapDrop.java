package day5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class bootstrapDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		
		WebElement dropdownEl = driver.findElement(By.xpath("//button[contains(@class,'multiselect')]"));
		dropdownEl.click();
		List<WebElement> listop = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//label"));
		System.out.println(listop.size());
		
		for(WebElement op:listop) {
			String option = op.getText();
			if(option.equals("HTML")|| option.equals("CSS")) {
				op.click();
			}
			if(option.equals("Java")|| option.equals("C#")) {
				op.click();
			}
		}
	}

}
