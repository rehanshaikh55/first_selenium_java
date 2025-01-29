package day7;

import java.time.Month;
import java.util.HashMap;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class datePicker2 {

	
	static void selectDate(WebDriver driver,String reqYear,String reqMonth,String reqDate) {
		WebElement yearDrop = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select selectYear = new Select(yearDrop);
		selectYear.selectByVisibleText(reqYear);
		
		
		while(true) {
		String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		
		Month ExpectedMonth = convertMonth(reqMonth);
		Month currentMonth= convertMonth(displayMonth);
		
		int result = ExpectedMonth.compareTo(currentMonth);
		if(result<0) {
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
		}else if(result>0) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}else {
			break;
		}
		
		}
		
		driver.findElement(By.xpath("//a[normalize-space()='"+reqDate+"']")).click();
	}

		static Month convertMonth(String month) {
			HashMap<String,Month> monthMap =new HashMap<String, Month>();
			monthMap.put("January", Month.JANUARY);
			monthMap.put("February", Month.FEBRUARY);
			monthMap.put("March", Month.MARCH);
			monthMap.put("April", Month.APRIL);
			monthMap.put("May", Month.MAY);
			monthMap.put("June", Month.JUNE);
			monthMap.put("July", Month.JULY);
			monthMap.put("August", Month.AUGUST);
			monthMap.put("September", Month.SEPTEMBER);
			monthMap.put("October", Month.OCTOBER);
			monthMap.put("November", Month.NOVEMBER);
			monthMap.put("December", Month.DECEMBER);
			
			Month vmonth = monthMap.get(month);
			if(vmonth ==null) {
				System.out.println("invailed month");
			}
			return vmonth;
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			WebDriver driver = new ChromeDriver();
			driver.get("https://fs11.formsite.com/6mhx7l/ieibpfavta/index");
			driver.findElement(By.xpath("//span[@role='button']")).click();
		
			String reqYear="2025";
			String reqMonth="July";
			String reqDate="21";
			
			selectDate(driver, reqYear, reqMonth, reqDate);
			
			
	}

}
