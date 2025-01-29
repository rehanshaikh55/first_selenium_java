package day6;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class statictablelogic {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://www.blazedemo.com/");
				driver.manage().window().maximize();
				
				//select flight
				driver.findElement(By.xpath("//select[@name='fromPort']")).click();
				driver.findElement(By.xpath("//option[@value='Mexico City']")).click();
				driver.findElement(By.xpath("//select[@name='toPort']")).click();
				driver.findElement(By.xpath("//option[@value='New York']")).click();
				driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
				
				
				int rows = driver.findElements(By.xpath("//tbody/tr")).size();
				System.out.println("total row size  "+rows);
				int cols = driver.findElements(By.xpath("//table[@class='table']//thead//tr/th")).size();
				System.out.println("total colomn size  "+cols);
				//find lowest price //tbody/tr/td[6]
				
				List<WebElement> values = driver.findElements(By.xpath("//tbody/tr/td[6]"));	
				
				ArrayList<String> aarrays = new ArrayList<>();
				
				for(WebElement newValue:values) {
					
					String array = newValue.getText();
					System.out.println(array);
					aarrays.add(array);
					
				}
				
				aarrays.sort(null);
				
				String lowestvalue= aarrays.getFirst();
				System.out.print(lowestvalue);
for(int i=1;i<=rows;i++) {
					String lowValue = values.get(i).getText();
					if(lowValue.equals(lowestvalue)) {
						System.out.print(lowValue);
						Thread.sleep(500);
						driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]//input")).click();
					}
					
				}
				
				
	}

}
