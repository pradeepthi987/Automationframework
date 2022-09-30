package PagePackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath="//input[@id=\"username\"]")
	WebElement username;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//button[@id=\"login\"]")
	WebElement loginbutton;
	
	@FindBy(xpath="//*[@id=\"register\"]")
	WebElement register;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoginTitle() {
		
		String Title1 = driver.getTitle();
		return Title1;
	}
	
	public boolean verifyRegister() {
		
		boolean reg = register.isDisplayed();
		return reg;
	}
	
	public LandingPage loginmethod(String un,String pw) {
		
		username.sendKeys(un);
		password.sendKeys(pw);
		
		loginbutton.click();
	
		return new LandingPage();
		
	}
	

}
