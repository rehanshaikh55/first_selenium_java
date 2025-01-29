package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstTestCase {

	public static void main(String[] args) throws InterruptedException {
	
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://spicejet.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[6]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]")).click();
		
			}

}
