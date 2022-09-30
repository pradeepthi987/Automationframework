package PageTestPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LandingPage;
import PagePackage.LoginPage;

public class LandingPageTest extends BaseClass{
	
	HomePage home;
	LoginPage login;
	LandingPage land;
	
	public LandingPageTest() {
		
		super();
	}
	
	@BeforeMethod

	public void setup() {
		initialization();
		home= new HomePage();
		login= new LoginPage();
		land = new LandingPage();
		
		
	}
	@Test
	public void verifyhometest() {
		
		boolean hom = land.verifyhm();
		Assert.assertTrue(hom);
	}
	
	@Test
	public void verifyschd() {
		boolean schd = land.verifysch();
		Assert.assertTrue(schd);
	}
	@Test
	public void verifydem() {
		boolean dem = land.verifydemo();
		Assert.assertTrue(dem);
	}
	@Test
	public void verifyfaq() {
		boolean faq = land.verifyfaq1();
		Assert.assertTrue(faq);
	}
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
}
