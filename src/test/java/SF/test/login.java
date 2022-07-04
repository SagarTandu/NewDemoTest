package SF.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class login {
	
public WebDriver driver;
public WebDriverWait w; 
public String url= "https://accounts.google.com/";

@BeforeSuite
public void initialize() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar.tandu\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
}

@Test (priority=0)
public void blank() {
	driver.get(url);
	driver.findElement(By.name("identifier")).sendKeys(" ");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String text = driver.findElement(By.xpath("//div[@class='o6cuMc']")).getText();
	System.out.println(text);
	Assert.assertEquals("Enter an email or phone number", text);
}



@Test (priority=1)
public void invalidemail() {
	driver.navigate().to(url);
	driver.findElement(By.name("identifier")).sendKeys("xxxxxxx@gmail.cons");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String text = driver.findElement(By.xpath("//div[@class='o6cuMc']")).getText();
	System.out.println(text);
	Assert.assertEquals("Couldn't find your Google Account", text);
}
	

@Test (priority=2)
public void invalidphone() {
	driver.navigate().to(url);
	driver.findElement(By.name("identifier")).sendKeys("1234567890112");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String text = driver.findElement(By.xpath("//div[@class='o6cuMc']")).getText();
	System.out.println(text);
	Assert.assertEquals("Enter a valid email or phone number", text);
}


@AfterSuite
public void close() {
	driver.quit();
  }
	
}