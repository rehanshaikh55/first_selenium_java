package day11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class facesearchai {

 public static void main(String[] args) throws InterruptedException {
 
 

 WebDriver driver = new ChromeDriver();
 
 driver.get("https://web.telegram.org/a/");
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 Thread.sleep(5000);
 
 WebElement phone = driver.findElement(By.xpath("//button[normalize-space()='Log in by phone Number']"));
 phone.click();
 Thread.sleep(1000);
 driver.findElement(By.xpath("//input[@id='sign-in-phone-number']")).sendKeys("9173188887");
 driver.findElement(By.xpath("//button[normalize-space()='Next']")).click(); //next button
 driver.findElement(By.xpath("//input[@id='telegram-search-input']")).click();// click search input
 driver.findElement(By.xpath("//input[@id='telegram-search-input']")).sendKeys("@facesearchai");
 driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]")).click();

 }
 
}
