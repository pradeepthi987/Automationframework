package PagePackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class LandingPage extends BaseClass {

	@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[1]/a")
	WebElement home;
	
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[2]/a")
	WebElement schedule;
	
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[3]/a")
	WebElement demos;
	
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[5]/a")
	WebElement faq;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	 public boolean verifyhm() {
		 
		 boolean hm = home.isDisplayed();
				 return hm;
		 
	 }
	 
	 public boolean verifysch() {
		 
		 boolean sch = schedule.isDisplayed();
		   return sch;
	 }
	 public boolean verifydemo() {
		 
		 boolean demo1 = demos.isDisplayed();
		 return demo1;
	 }
	 public boolean verifyfaq1() {
		 
		 boolean faq1 = faq.isDisplayed();
		 return faq1;
	 }
}
