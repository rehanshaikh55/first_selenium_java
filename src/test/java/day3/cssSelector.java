package day3;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssSelector {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().setSize(new Dimension(375, 812));;
		
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='login-button']")).click();
		WebElement element = driver.findElement(By.id("item_3_img_link"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		element.click();
	  WebElement product=	driver.findElement(By.cssSelector(".inventory_details_name.large_size"));
		WebElement addToCart = driver.findElement(By.id("add-to-cart"));
		addToCart.click();
		
		String productDetails = product.getText();
		System.out.println("Product  "+productDetails+" is added");
		
		
		
		driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
		driver.findElement(By.cssSelector("button#checkout")).click();
		driver.findElement(By.cssSelector("input#first-name")).sendKeys("Rehan");
		driver.findElement(By.cssSelector("input#last-name")).sendKeys("Shaikh");
		driver.findElement(By.cssSelector("input#postal-code")).sendKeys("380015");
		driver.findElement(By.cssSelector("input#continue")).click();
		driver.findElement(By.cssSelector("button#finish")).click();
		driver.findElement(By.cssSelector("button#back-to-products")).click();
		System.out.println("test pass");
		driver.close();
	}

}
