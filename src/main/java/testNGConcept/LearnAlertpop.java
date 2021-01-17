package testNGConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlertpop {
	WebDriver driver;
	
	@Test
	public void launchbrower() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]"));
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]"));
		
		String alertMsg =driver.switchTo().alert().getText();
		System.out.println("=========" + alertMsg);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		
		
	}

}
