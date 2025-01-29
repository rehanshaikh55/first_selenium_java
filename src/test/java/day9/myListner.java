package day9;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class myListner implements ITestListener {
WebDriver driver;
	public void onStart(ITestContext context) {
		         System.out.println("test excution started");
		  }

		  
	
	
	
	public  void onTestStart(ITestResult result) {
		System.out.println("test start");
	  }
	public void onTestSuccess(ITestResult result) {
		System.out.println("test passed");
	  }

	  
	public void onTestFailure(ITestResult result ) {
		
		System.out.println("test failed");
		 
	  }

	  
	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped");
	  }
	
	
	
	public void onFinish(ITestContext context) {
		System.out.println("test excecution finished");
	}
}
