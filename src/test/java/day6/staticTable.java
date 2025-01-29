package day6;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class staticTable {

	public static void main(String[] args) {
WebDriver driver = new ChromeDriver();
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://testautomationpractice.blogspot.com/");
				driver.manage().window().maximize();
				
				int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
				System.out.println("total row size  "+rows);
				int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
				System.out.println("total colomn size  "+cols);
				
				/*for(int r=2;r<=rows;r++) {
					for(int c=1;c<=cols;c++) {
						        String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
						        System.out.print(value+"\t");
					}
					System.out.println();
				}*/
				/*
				for(int i=2;i<=rows;i++) {
					String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
					if(value.equals("Mukesh")) {
						
						String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
						System.out.println(bookName);
					}
				}*/
				
					List<WebElement> value = driver.findElements(By.xpath("//table[@name='BookTable']//tr//td[4]"));
					int total = 0;
					for(WebElement price:value) {
						String prices = price.getText();
						total=total + Integer.parseInt(prices);
					}
					
					System.out.println(total);
				
				
	}

}
