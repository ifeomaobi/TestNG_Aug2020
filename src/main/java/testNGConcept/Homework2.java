package testNGConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Homework2 {
	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void loginTest() throws InterruptedException {
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\"username\"]"));
		WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		USERNAME_FIELD_ELEMENT.clear();
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_FIELD_ELEMENT.clear();
		PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.click();
		Thread.sleep(3000);
		
		WebElement DASHBOARD_FIELD_ELEMENT = driver.findElement(By.linkText("Dashboard"));
		String actualDashboardElement = DASHBOARD_FIELD_ELEMENT.getText();
		System.out.println("================" + actualDashboardElement);
		Assert.assertEquals("Dashboard page not found", "Dashboard", actualDashboardElement);
		
		WebElement CUSTOMERS_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
		CUSTOMERS_FIELD_ELEMENT.click();
		WebElement ADDCUSTOMER_BUTTON_ELEMENT = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a"));
		ADDCUSTOMER_BUTTON_ELEMENT.click();
		
		WebElement CONTACTNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\"account\"]"));
		CONTACTNAME_FIELD_ELEMENT.sendKeys("Ifeoma Nwajagu");
		
		WebElement COMPANY_FIELD_ELEMENT = driver.findElement(By.xpath("//select[@id=\"cid\"]"));
		Select sel = new Select(COMPANY_FIELD_ELEMENT);
		sel.selectByVisibleText("Techfios");
		
		WebElement EMAIL_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		WebElement PHONE_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\"phone\"]"));
		WebElement ADDRESS_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\"address\"]"));
		WebElement CITY_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\"city\"]"));
		WebElement STATE_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\"state\"]"));
		WebElement ZIPCODE_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\"zip\"]"));
		
		
		EMAIL_FIELD_ELEMENT.sendKeys("ifeyobi@gmail.com");
		PHONE_FIELD_ELEMENT.sendKeys("2148009000");
		ADDRESS_FIELD_ELEMENT.sendKeys("123 john St");
		CITY_FIELD_ELEMENT.sendKeys("McKinney");
		STATE_FIELD_ELEMENT.sendKeys("TX");
		ZIPCODE_FIELD_ELEMENT.sendKeys("75070");
		
		WebElement GROUP_FIELD_ELEMENT = driver.findElement(By.xpath("//select[@id=\"group\"]"));
		Select sel1 = new Select(GROUP_FIELD_ELEMENT);
		sel1.selectByVisibleText("AUG 2020");
		
		WebElement SAVE_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@id=\"submit\"]"));
		SAVE_BUTTON_ELEMENT.click();
				
}
	
	public void loginTest1() {
		WebElement CUSTOMERS_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
		CUSTOMERS_FIELD_ELEMENT.click();
		WebElement LISTCUSTOMER_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a"));
		LISTCUSTOMER_FIELD_ELEMENT.click();
	}
	
	public void tearDown() {
		driver.close();
	}
}
