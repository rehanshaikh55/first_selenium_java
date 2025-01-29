package day8;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.utils.excelUtils;

public class fdCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
     
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
	    driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    
	     driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
	    String filepath = "C:\\Users\\shaik\\eclipse-workspace\\seleniumwebdriver\\testdata\\data.xlsx";
	    
	   int totalrow = excelUtils.getRowCount(filepath,"Sheet1");
	  
	    System.out.println(totalrow);
	    
	    
	    for(int r=1;r<=totalrow;r++) {
	    	String pri=  excelUtils.getCellData(filepath, "Sheet1", r,0);
	    	String rateofintrest =excelUtils.getCellData(filepath, "Sheet1", r,1);
	    	String per1= excelUtils.getCellData(filepath, "Sheet1", r,2);
	    	String per2= excelUtils.getCellData(filepath, "Sheet1", r,3);
	    	String fre= excelUtils.getCellData(filepath, "Sheet1", r,4);
	    	String maturity_val= excelUtils.getCellData(filepath, "Sheet1", r,5);
	    	
	    	
	    	
	    	driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pri);
	    	driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofintrest);
	    	driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
	    	
	    	
	    	Select pre_drp = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
	    	pre_drp.selectByVisibleText(per2);
	    	Select fre_drp = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
	    	fre_drp.selectByVisibleText(fre);
	    	Thread.sleep(1);
	    	driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
	    	
	    	String act_value = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
	    	System.out.println(act_value);
	    	if(Double.parseDouble(act_value) == Double.parseDouble(maturity_val)) {
	    		System.out.println("test passed");
	    		excelUtils.setCellData(filepath, "Sheet1", r, 7, "passed");
	    		excelUtils.fillGreenColor(filepath, "Sheet1", r, 7);
	    		
	    	}else {
	    		System.out.println("test failed");
	    		excelUtils.setCellData(filepath, "Sheet1", r, 7, "failed");
	    		excelUtils.fillRedColor(filepath, "Sheet1", r, 7);
	    	}
	    	driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[2]/div[1]/div[5]/div[1]/div[1]/div[3]/form[1]/div[2]/a[2]/img[1]")).click();
	    }
	}

}
