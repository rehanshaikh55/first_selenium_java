package day7;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datePicker {
	
	static void selectFutureDate(WebDriver driver,String month,String year,String day) {
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
		driver.findElement(By.xpath("//a[@data-date='"+day+"']")).click();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://testautomationpractice.blogspot.com/");
				driver.manage().window().maximize();
				WebElement datepicker =driver.findElement(By.xpath("//input[@id='datepicker']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", datepicker);
				datepicker.click();
				
				String year = "2025";
				String month = "July";
				String day = "21";
				
				selectFutureDate(driver, month, year, day);
				
	}

}
