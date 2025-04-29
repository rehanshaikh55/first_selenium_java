package day11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	LoginPage(WebDriver driver){
	 this.driver=driver;
	 PageFactory.initElements( driver,this);
	}
	
	//Locators
	
	@FindBy(xpath ="//input[@placeholder='Username']") WebElement txt_username;
	@FindBy(xpath ="//input[@placeholder='Password']") WebElement txt_password;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement login_btn;
	
	
	
	
	public void setUsername(String user) {
		txt_username.sendKeys(user);
	}
	
	public	void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	public	void clickLogin() {
		login_btn.click();
	}
}
