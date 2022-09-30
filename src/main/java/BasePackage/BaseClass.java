package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import UtilsPackage.Utils;
import UtilsPackage.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	    public static WebEventListener eventListener;

	
	public BaseClass() {
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\deept\\eclipse-workspace\\Automationframework\\src\\main\\java\\ConfigPackage\\Config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
public static void initialization() {
	String browsername = prop.getProperty("browser");
	WebDriver driver = new ChromeDriver();
	if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deept\\eclipse-workspace\\Automationframework\\src\\main\\resources\\Browsers\\chromedriver.exe");
	driver=new ChromeDriver();
}

else if(browsername.equals("gecko")) {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\deept\\eclipse-workspace\\Automationframework\\src\\main\\resources\\gecko\\geckodriver.exe");
	driver=new FirefoxDriver();
}
	e_driver=new EventFiringWebDriver(driver);  //create an object for EventFiringWEbDriver
    eventListener = new WebEventListener(); //create object of EventListenerHandler to register it with EventFiringWebDriver
    e_driver.register(eventListener);
    driver = e_driver;
driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));


}
}


