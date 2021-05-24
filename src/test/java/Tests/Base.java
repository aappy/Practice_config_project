package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	
	public WebDriver driver;
	
	public WebDriver setUp() throws IOException  {
		
	   Properties prop = new Properties();	
	   
	   FileInputStream fis = new FileInputStream("/Users/aparnachdhry/eclipse-workspace/Practice_config_project/src/main/java/resource/data.properties");		

	   prop.load(fis);
		
	   String browserName = System.getProperty("browser");
	   
	   if(browserName.equals("chrome")) {
		   System.setProperty("webdriver.chrome.driver","/Users/aparnachdhry/Documents/Software/drivers/chromedriver/chromedriver");
		   driver = new ChromeDriver();
	   }
	   else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver","/Users/aparnachdhry/Documents/Software/drivers/geckodriver/geckodriver");
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("safari")) {

			System.setProperty("webdriver.safari.driver", "/Macintosh HD/usr/bin/safaridriver");
			driver = new SafariDriver();
		}
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    return driver;	
	}
	
	public void tearDown() {
		
	}
}
