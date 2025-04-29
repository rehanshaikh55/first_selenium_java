package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class neilclicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new  ChromeDriver();
		driver.get("https://neal.fun/stimulation-clicker/");
		driver.manage().window().maximize();
		for(int i=0;i<=100;i++) {
			driver.findElement(By.xpath("//button[normalize-space()='Click me']")).click();
		}

	}

}
