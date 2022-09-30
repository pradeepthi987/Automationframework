package PageTestPackage;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LandingPage;
import PagePackage.LoginPage;
import UtilsPackage.Utils;
import UtilsPackage.Utilsdata;

public class LoginPageTest extends BaseClass {
	
	private static final String TestUtil = null;
	HomePage home;
	LoginPage login;
	LandingPage land;
	
public LoginPageTest() {
	
	super();
}

@BeforeMethod

public void setup() {
	initialization();
	home= new HomePage();
	login= new LoginPage();
	land = new LandingPage();
	home.verifylogin();
	
}
@Test(priority=1)

 public void validatelogintitletest() {
	
	String actual = login.verifyLoginTitle();
	String expected = "QA/QE/SDET Training.";
	Assert.assertEquals(actual, expected);
	
}




@Test(priority=2)
 public void logintest()   {
	land = login.loginmethod(prop.getProperty("username"),prop.getProperty("password"));
	
}

@AfterMethod

public void teardown() {
	
	driver.close();
}










}
