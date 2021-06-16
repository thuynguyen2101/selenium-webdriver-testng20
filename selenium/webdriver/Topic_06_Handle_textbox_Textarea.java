package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Handle_textbox_Textarea {
	WebDriver driver;
	String emailAddress;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		emailAddress=getrandomEmail();
		
	}

	@Test
	public void Register() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		
		
	}

	@Test
	public void Login() {

	}

	@Test
	public void Create_new_Customer() {

	}
	@Test
	public void Edit_cusomter() {

	}
	@Test
	public void Delete_customer() {

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public String getrandomEmail(){
		Random rand= new Random();
		return "thuy"+ rand.nextInt(999999)+ "@gmail.com";
	}
}
