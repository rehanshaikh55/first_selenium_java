package day7;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.Window;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class luscars {

	static void filtercheck(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/select[1]")).click();
		driver.findElement(By.xpath("//option[@value='en']")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/div[2]/a[2]")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Filter']")).click();
		
		WebElement filterManual = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[5]/div[2]/div[1]/div[1]/label[1]"));
		String name =   filterManual.getText();
		filterManual.click();
		driver.findElement(By.xpath("//button[@class='text-white']")).click();
		List<WebElement> sizeResult = driver.findElements(By.xpath("//div[@class='bg-[#F1F1F1] rounded-3xl p-6 relative']"));
		
		for(int i=1;i<=sizeResult.size();i++) {
		WebElement filterResult = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div["+i+"]/div[3]/a[1]/button[1]"));
	     //System.out.println(filterResult.size());
		
		    filterResult.click();
		    Thread.sleep(1000);
		    WebElement screenshotSection = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]"));
		    TakesScreenshot ts =(TakesScreenshot)driver;
		    File sourcefile = screenshotSection.getScreenshotAs(OutputType.FILE);
		    File targetFile = new File("C:\\Users\\shaik\\eclipse-workspace\\seleniumwebdriver\\screenshot\\sc"+i+".png");
		    sourcefile.renameTo(targetFile);
			
		    
		    String exptResult = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]")).getText();
		    if( exptResult.equals(name)) {
		    	System.out.println("Product check pass. "+"it is "+ name);
		    }
		    Thread.sleep(1000);
		    driver.navigate().back();
		}
		System.out.println("Filter Check Pass");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
	
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://dotpitchtechnologies.com/luscars");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://dotpitchdigital.com/");
		
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(0));
		
		filtercheck(driver);
		
	}

}
