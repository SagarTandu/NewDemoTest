package SF.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Invalidemail {
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
	driver.findElement(By.name("identifier")).sendKeys("xxxxxxx@gmail.cons");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test
public void text() {
	String text = driver.findElement(By.xpath("//div[@class='o6cuMc']")).getText();
	System.out.println(text);
	Assert.assertEquals("Couldn't find your Google Account", text);
	
}

@AfterSuite
public void close() {
	driver.quit();
  }
	
}
