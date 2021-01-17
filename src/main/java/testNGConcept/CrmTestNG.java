package testNGConcept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrmTestNG {
	WebDriver driver;
	
	@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
//		driver.get("https://www.cnn.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void dealWithDynamicWebElement() {
//		driver.findElement(By.xpath("//ul[@class='cn cn-list-hierarchical-xs cn--idx-0 cn-container_C7586E1A-7321-AE9A-FA17-F14028802010']/descendants::span[3]")).click();
//		store Web Element formula
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\'password\']"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		USERNAME_FIELD_ELEMENT.clear();
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_FIELD_ELEMENT.clear();
		PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.click();
		
//		Store web element using by class
//		By USERNAME_FIELD_LOCATOR = By.xpath("//input[@id='username']");
//		By PASSWORD_FIELD_LOCATOR = By.xpath("//input[@id=\'password\']");
		
//		you call by using this method
//		driver.findElement(USERNAME_FIELD_LOCATOR).sendKeys("demo@techfios.com");
//		driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys("abc123");
		
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
