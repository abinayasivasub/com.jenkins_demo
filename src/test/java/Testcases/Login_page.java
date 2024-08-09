package Testcases;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_page 
{
	WebDriver driver;
		
	@BeforeTest
	public void setUp()
	{
		driver= new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void validateTitle()
	{
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		
		Assert.assertEquals(actual_title,"Facebook – log in or sign up");
	}
	
	@Test
	public void validateUrl()
	{
		String actual_url = driver.getCurrentUrl();
		System.out.println(actual_url);
		Assert.assertEquals(actual_url, "https://www.facebook.com/");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
