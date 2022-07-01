package SF.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

	public class Validemail {
	public WebDriver driver;
		

	@BeforeSuite
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar.tandu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void login() {
		driver.get("https://mail.google.com/ ");
		driver.findElement(By.name("identifier")).sendKeys("sagar.tandu@sourcefuse.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@Test
	public void welcome() {
		WebElement WelcomeMsg = driver.findElement(By.xpath("//span[contains(text(), 'Welcome')]"));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(WelcomeMsg));
		String message = WelcomeMsg.getText();
		System.out.println(message);
		Assert.assertEquals("Welcome", message);
		
	}

	@AfterSuite
	public void close() {
		driver.quit();
	  }
		
}
