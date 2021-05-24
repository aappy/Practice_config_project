package Tests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*
 * Hard assertion : 
 */
public class OpencatsLogin {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	public void createDBConn() {		
		System.out.println("create DB conn");		
	}
	
	@AfterTest
	public void closeDBConn() {		
		System.out.println("close DB conn");		
	}
	
	@BeforeClass
	public void launchBrowser() {				
		 System.setProperty("webdriver.chrome.driver","/Users/aparnachdhry/Documents/Software/drivers/chromedriver/chromedriver");
		 driver = new ChromeDriver();
		 driver.get("https://demo.opencats.org/index.php?m=login");
	}
	
//	@AfterMethod
//	public void closeBrowser() {		
//		driver.close();
//		System.out.println("close Browser");	
//	}
	
	@Test(dataProvider="users")
	public void LoginTest(String uname , String pass) throws Exception {
		
		
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement submit = driver.findElement(By.xpath("//*[@id='subFormBlock']/input[3]"));
		
		username.sendKeys(uname);
		password.sendKeys(pass);	
		submit.click();
		
		System.out.println("submitted");

		boolean expected = true;
		boolean actual = driver.getPageSource().contains("Logout");
		
		Thread.sleep(1000);
		
		softAssert.assertEquals(actual, expected);	
	}
		
	@DataProvider(name="users") //@DataProvider is a annotation
	
	   String[][] loginData(){	
	   String data[][]= { {"open","yhUqysy"}, {"mngr302602","233"}
                      };
		return data;
	}


//	@Test(priority=3, dependsOnMethods="Test1" )
//	public void Test2() {
//		
//	}
	
//	@Test(priority=2)
//	public void ValidateTitles() {
	
//		SoftAssert softAssert = new SoftAssert();		
//		String expected = "Aparna";
//		String actual = "lokes";
//		
//		AssertJUnit.assertEquals(actual, expected);
//	
//		System.out.println("This is ValidateTitles");
//		
//		boolean s = expected.equals(actual);
//		AssertJUnit.assertTrue(true);
//		
//		System.out.println("This is ddddd");
//		//softAssert.fail("Failing a test as result not matched");		
//		softAssert.assertAll();		
//	}
	
}
