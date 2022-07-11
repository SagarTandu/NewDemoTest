package SF.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	
public WebDriver driver;
public WebDriverWait w; 
public String url= "https://accounts.google.com/";
public Actions act;



@Test (priority=0)
public void initialize() {

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar.tandu\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/Automate/drivers/chromedriver");
	ChromeOptions ch = new ChromeOptions();
	//ch.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080","--no-sandbox");		
	driver=new ChromeDriver(ch);
	act = new Actions(driver);
	driver.manage().window().maximize();
	driver.get(url);

}

@Test (priority=1)
public void blank() {
	
	driver.findElement(By.name("identifier")).sendKeys(" ");
	act.sendKeys(Keys.ENTER).build().perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	String text = driver.findElement(By.xpath("//*[text()='Enter an email or phone number']")).getText();
	System.out.println(text);
	Assert.assertEquals("Enter an email or phone number", text);
	
}


@Test (priority=2)
public void invalidemail() throws InterruptedException {
	
	driver.navigate().to(url);
	driver.findElement(By.name("identifier")).sendKeys("sagar.tndu@gmail");
	act.sendKeys(Keys.ENTER).build().perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	String text = driver.findElement(By.xpath("//*[text()='Enter a valid email or phone number']")).getText();
	System.out.println(text);
	Assert.assertEquals("Enter a valid email or phone number", text);
	
}
	

@Test (priority=3)
public void invalidphone() {
	
	driver.navigate().to(url);
	driver.findElement(By.name("identifier")).sendKeys("9177@14370");
	act.sendKeys(Keys.ENTER).build().perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String text = driver.findElement(By.xpath("//*[text()='Enter a valid email or phone number']")).getText();
	System.out.println(text);
	Assert.assertEquals("Enter a valid email or phone number", text);
	
    }
	
}