package Tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
//	WebDriver  driver;
//	
//	@Test(priority=1)
//	public void loginTest() {
//		  WebDriverManager.chromedriver().setup();
//		  driver = new ChromeDriver();
//		  driver.get("https://testautomationpractice.blogspot.com/");
//	}
//	
//	@Test(priority=2)
//	public void okAlert() throws Exception {
//		//This is second test
//		driver.findElement(By.xpath("//*[contains(text() , 'Click Me')]")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().accept();	
//		System.out.println("clicked ok");
//		Thread.sleep(3000);
//	}
		
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	void setup() {
		
		System.setProperty("webdriver.chrome.driver","/Users/aparnachdhry/Documents/Software/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();		
	}
	
	@Test(dataProvider = "users") //dataProvider is parameter of @Test
	void logintest(String userName , String password) throws Exception {

		driver.get("http://demo.guru99.com/v4/index.php");
		
		driver.findElement(By.xpath("//*[@name = 'uid']")).sendKeys(userName);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name = 'password']")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type = 'submit']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();  //it test positive no alert and failed alert
	
		Thread.sleep(5000);
		
	    String actualTitle = driver.getTitle();
	    System.out.println("TITLE = " + actualTitle);
	   
	    Assert.assertEquals(actualTitle, "Guru99 Bank Home Page");   
	}
	
	@DataProvider(name="users") //@DataProvider is a annotation
	
	   String[][] loginData(){
		
		//Actually we need to read data from XML or database but we are hard coding here for example
		// 2 dim array for u.name and pass
		//IMP : we achieve  data driven testing in testNg using @DataProvider
		
		String data[][]= {{"mngr302602","233"},{"mngr324590","UpynebY"}
                         };
		return data;
	}
}
