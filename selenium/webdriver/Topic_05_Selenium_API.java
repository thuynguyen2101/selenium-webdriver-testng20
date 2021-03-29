package webdriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_05_Selenium_API {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test(enabled=false)
	public void TC_01_VerifyURL() {
		//Open app
		driver.get("http://live.demoguru99.com");
		
		//Click on My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
		
		//Click on the Create an account
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.demoguru99.com/index.php/customer/account/create/");
	}

	@Test(enabled=false)
	public void TC_02_Verify_Title() {
		//Open app
		driver.get("http://live.demoguru99.com");
		
		//Click on My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		
		//Click on the Create an account
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@Test(enabled=false)
	public void TC_03_Nagative_function() {
		//Open app
		driver.get("http://live.demoguru99.com");
		
		//Click on My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		//Click on the Create an account
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
		
		//Back to the Login Page
		driver.navigate().back();
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
		
		//Foward to Register Page
		driver.navigate().forward();
		
		//Verify Title cuar Register Page
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}
	@Test(enabled=false)
	public void TC_04_Getpage_Source_code() {
		//Open app
		driver.get("http://live.demoguru99.com");
		
		//Click on My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
		
		//Click on the Create an account
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
	}
	
	@Test
	public void TC_05_Register_a_new_account() {
		//Open app
		driver.get("http://live.demoguru99.com");
		
		//Click on My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		//Click on the Create an account
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		
		driver.findElement(By.id("firstname")).sendKeys("Nguyen");
		driver.findElement(By.id("middlename")).sendKeys("Thi");
		driver.findElement(By.id("lastname")).sendKeys("Thuy");
		driver.findElement(By.id("email_address")).sendKeys("thuy"+GetRandomNumber()+"@podfoods.co");
		driver.findElement(By.id("password")).sendKeys("12345678a");
		driver.findElement(By.id("confirmation")).sendKeys("12345678a");
		
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']")).getText(), "Thank you for registering with Main Website Store.");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int GetRandomNumber()
	{
		Random Number= new Random();
		return Number.nextInt();
		
		
	}
}
