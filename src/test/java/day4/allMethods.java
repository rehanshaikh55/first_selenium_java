package day4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class allMethods {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://testautomationpractice.blogspot.com/");
				driver.manage().window().maximize();
			
				driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
         driver.findElement(By.xpath("//input[@type='submit']")).click();
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
         wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
         
       
        
        List<WebElement> links = driver.findElements(By.id("wikipedia-search-result-link"));

        // Debug: Print all href attributes
        System.out.println("All links found:");
        for (WebElement linkElement : links) {
            System.out.println(linkElement.getAttribute("href"));
        }

        // Filter and open valid Wikipedia links
        for (WebElement linkElement : links) {
            String link = linkElement.getAttribute("href");
            if (link != null && !link.trim().isEmpty() && link.startsWith("wikipedia.org")) {
                System.out.println("Opening Wikipedia link: " + link);
                ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", link);
            } else if (link == null || link.trim().isEmpty()) {
                System.out.println("Skipped invalid link (null or empty).");
            }
        }
 			
 				
	}

}
