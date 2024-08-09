package Testcases;
import java.time.Duration;

import org.openqa.selenium.By;
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
	
	@Test
	public void validate_forgot_password()
	{
		String actual_fp_text=driver.findElement(By.linkText("Forgotten password?")).getText();
		Assert.assertEquals(actual_fp_text, "Forgotten password?");
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
