package SF.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Compose {
	public WebDriver driver;
	public WebDriverWait w; 
	public String url= "https://mail.google.com/";
	public Actions act;

	@BeforeSuite
	public void browser() {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar.tandu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/Automate/drivers/chromedriver");
		driver=new ChromeDriver(ch);
		//WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
	    driver.navigate().to(url);
	}
	
	
	@Test
	public void composeemail() {
		driver.findElement(By.name("identifier")).sendKeys("abcdsourcefuse@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement WelcomeMsg = driver.findElement(By.xpath("//span[contains(text(), 'Welcome')]"));
		w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(WelcomeMsg));
		String message = WelcomeMsg.getText();
		System.out.println(message);
		Assert.assertEquals("Welcome", message);
		driver.findElement(By.name("password")).sendKeys("Sagar@123");
		driver.findElement(By.id("passwordNext")).click();
		WebElement comp = driver.findElement(By.xpath("//div[text()='Compose']"));
		comp.click();
		driver.findElement(By.className("vO")).click();
		driver.findElement(By.className("vO")).sendKeys("abcdsourcefuse@gmail.com");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.className("aoT")).sendKeys("SourceFuse");
		driver.findElement(By.className("Am")).sendKeys("This is a test email");
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		String sentmessage = driver.findElement(By.xpath("//span[text()='Message sent']")).getText();
		System.out.println(sentmessage);
	}
	
   @AfterSuite
	public void close() {
		driver.quit();
	}
	
	
}
