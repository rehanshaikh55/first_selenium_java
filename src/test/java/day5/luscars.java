package day5;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class luscars {

	public static void main(String[] args) throws InterruptedException {
           
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://uat-bugbounty.nonprod.syfe.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        // Check each link
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            
            // Skip empty or null links
            if (url == null || url.isEmpty()) {
                System.out.println("Empty or null link found.");
                continue;
            }
 
            // Test the link
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD"); // Use HEAD to avoid downloading content
                connection.connect();
                int responseCode = connection.getResponseCode();
                

                // Check response code
                if (responseCode >= 400) {
                    System.out.println("Broken link: " + url + " - Response Code: " + responseCode);
                } else {
                	
                    System.out.println("Valid link: " + url + " - Response Code: " + responseCode);
                }
            } catch (IOException e) {
                System.out.println("Error checking link: " + url + " - Exception: " + e.getMessage());
            }
        }
		
	}
/*
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		long startTime = System.currentTimeMillis();

        // Navigate to the website
        driver.get("https://dotpitchtechnologies.com/luscars");

        // End time after the page is fully loaded
        long endTime = System.currentTimeMillis();

        // Calculate and display load time
        long loadTime = endTime - startTime;
        System.out.println("Page Load Time: " + loadTime + " milliseconds");

        // Optional: Measure load time for specific elements
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'text-white relative')]"));
        long elementStartTime = System.currentTimeMillis();
        element.isDisplayed();  // Ensure the element is loaded
        long elementEndTime = System.currentTimeMillis();
        System.out.println("Element Load Time: " + (elementEndTime - elementStartTime) + " milliseconds");

*/


/*
		@Test
		
		
		public void testPageLoadPerformance() {
			long startTime = System.currentTimeMillis();
			WebDriver driver = new ChromeDriver();
			driver.get("https://dotpitchtechnologies.com/");
			long endTime = System.currentTimeMillis();
			long loadTime = endTime - startTime;
			
			System.out.println("Page Load Time: " + loadTime + " milliseconds");
			
			// Assert a threshold for load time (e.g., 3 seconds)
			Assert.assertTrue(loadTime < 3000, "Page load time is too high!");
		
			
		}
*/
}
