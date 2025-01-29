package day5;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class handleFrame {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		/*
		//Frame 1
		WebElement frame1=driver.findElement(By.xpath("/html[1]/frameset[1]/frame[1]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Rehan");
		
		driver.switchTo().defaultContent();
		
		//Frame 2
		WebElement frame2=driver.findElement(By.xpath("/html[1]/frameset[1]/frameset[1]/frame[1]"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Shaikh");
		driver.switchTo().defaultContent();
	
	    //Frame 3 
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Welcome");
		WebElement frame3_1=driver.findElement(By.cssSelector("iframe[src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
	      driver.switchTo().frame(0);
	      driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
	*/
		WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		WebElement logoimage= driver.findElement(By.xpath("//img[@alt='Ui.Vision by a9t9 software - Image-Driven Automation']"));
		System.out.println(logoimage.isDisplayed());
		driver.findElement(By.xpath("//span[normalize-space()='1. Get Ui.Vision (free)']")).click();
		
	}

}
