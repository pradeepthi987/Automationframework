package PageTestPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LoginPage;

public class HomePageTest extends BaseClass {
	
	HomePage home;
	LoginPage login;
	
	public HomePageTest() {
		
		super();
	}
	
@BeforeMethod	
public void setup() {
	
	initialization();
	home = new HomePage();
}

@Test
public void TestTitle() {
	String actual = home.verifyTitle();
	String expected = "QA/QE/SDET Training.";
	Assert.assertEquals(actual, expected);
	
}
@Test
public void verifylogotest() {
	boolean logo = home.verifywbllogo();
	Assert.assertTrue(logo);
}
@Test
public void verifystudentaccesstest() {
	boolean student = home.verifystudent();
			Assert.assertTrue(student);
}
@Test
public void verifywbltest() {
boolean wblhead	=home.verifywblhead();
Assert.assertTrue(wblhead);
}
@Test
public void Testloginbtn() {
home.verifylogin();

}
@AfterMethod
public void TearDown() {
	driver.close();
}
	


}
