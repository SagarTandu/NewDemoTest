package SF.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
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

@BeforeClass
public void initialize() {
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar.tandu\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver", "C://Users//sagar.tandu//eclipse-workspace//test//drivers//chromedriver");
	//System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/Automate/drivers/chromedriver");
	ChromeOptions ch = new ChromeOptions();
	//ch.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");		
	ch.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080","--no-sandbox");		
	System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/Automate/drivers/chromedriver");
	driver=new ChromeDriver(ch);
	driver.manage().window().maximize();
	driver.get(url);

}

@Test (priority=0)
public void blank() {
	
	Actions act = new Actions(driver);
	driver.findElement(By.name("identifier")).sendKeys(" ");
	act.sendKeys(Keys.ENTER).build().perform();
	//driver.findElement(By.xpath("//span[text()='Next']")).click();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String text = driver.findElement(By.xpath("//div[@class='o6cuMc']")).getText();
	System.out.println(text);
	Assert.assertEquals("Enter an email or phone number", text);
	
}



//@Test (priority=1)
public void invalidemail() {
	/*
	driver.navigate().to(url);
	driver.findElement(By.name("identifier")).sendKeys("xxxxxxx@gmail.cons");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String text = driver.findElement(By.xpath("//div[@class='o6cuMc']")).getText();
	System.out.println(text);
	Assert.assertEquals("Couldn't find your Google Account", text);
	*/
	System.out.println("invalidemail");

}
	

//@Test (priority=2)
public void invalidphone() {
	/*
	driver.navigate().to(url);
	driver.findElement(By.name("identifier")).sendKeys("1234567890112");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String text = driver.findElement(By.xpath("//div[@class='o6cuMc']")).getText();
	System.out.println(text);
	Assert.assertEquals("Enter a valid email or phone number", text);
	*/
	System.out.println("invalidphone`");
	
    }
	
}