package PagePackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//*[@id=\"logo\"]")
	WebElement wbqa;
	
	@FindBy(xpath="//*[@id=\"headerfblogin\"]")
	WebElement studentaccess;
	
	@FindBy(xpath="//a[@id=\"wblhead\"]")
	WebElement wbl;
	
	@FindBy(xpath="//a[@id=\"loginButton\"]")
	WebElement loginbutton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
 public String verifyTitle() {
	 
	String title=driver.getTitle() ;
	return title;
 }
 
 public boolean verifywbllogo() {
	 
	 boolean logo = wbqa.isDisplayed();
			 return logo;
	 
 }
 public boolean verifystudent() {
	 
	 boolean student = studentaccess.isDisplayed();
	 return student;
	 
 }
 public boolean verifywblhead() {
	 
	 boolean head = wbl.isDisplayed();
	 return head;
 }
 public LoginPage verifylogin() {
	 
	 loginbutton.click();
	 return new LoginPage();
	 
	 
 }
}
