package PageTestPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LandingPage;
import PagePackage.LoginPage;

public class DataDrivenTest extends BaseClass {
	HomePage home;
	LoginPage login;

	LandingPage land;
	public DataDrivenTest() {
		super();
	}
	
@BeforeMethod

public void setup(){
	initialization();
	home = new HomePage();
    login = new LoginPage();
    land = login.loginmethod(String un, String pw);
	land = new LandingPage();
	

}
@Test(DataProvider = "Testdata")
public void DataDrivenTest(String username,String password) {
	LandingPage = login.loginmethod(username, password);
	
}
@DataProvider(name = "Testdata")
public Object[][] getdata(){
	
	
}
@AfterMethod
public void teardown() {
	driver.quit();
}
}
