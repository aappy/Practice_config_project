import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	WebDriver  driver;
	
	@Test(priority=1)
	public void loginTest() {
		
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	@Test(priority=2)
	public void okAlert() throws Exception {
		
		driver.findElement(By.xpath("//*[contains(text() , 'Click Me')]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();	
		System.out.println("clicked ok");
		Thread.sleep(3000);
	}
}
