package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Handle_textbox_Textarea {
	WebDriver driver;
	String emailAddress, loginPageUlr, userID, password, customId,gender;
	String name, dateOfBirth,address, city, state, pin, phone;
	By nameTextbox = By.xpath("//input[@name='name']");
	By genderSelectbox = By.xpath("//input[@value='m']");
	By dobTextbox = By.xpath("//input[@name='dob']");
	By addressTextbox = By.xpath("//textarea[@name='addr']");
	By cityTextbox = By.xpath("//input[@name='city']");
	By stateTextbox = By.xpath("//input[@name='state']");
	By pinTextbox = By.xpath("//input[@name='pinno']");
	By phoneTextbox = By.xpath("//input[@name='telephoneno']");
	By emailTextbox = By.xpath("//input[@name='emailid']");
	By passwordTextbox = By.xpath("//input[@name='password']");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		emailAddress=getrandomEmail();
		name="Jonh Bin";
		gender= "male";
		dateOfBirth="2020-05-09"; 
		address= "54 Lieu Giai"; 
		city="New York City"; 
		state= "New York"; 
		pin="321456"; 
		phone="7896541235";
	}

	@Test
	public void TC_01_Register() {
		loginPageUlr = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		userID = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText();

	}

	@Test
	public void TC_02_Login() {
		driver.get(loginPageUlr);
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(),
				"Welcome To Manager's Page of Guru99 Bank");
	}

	@Test
	public void TC_03_Create_new_Customer() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		driver.findElement(nameTextbox).sendKeys(name);
		driver.findElement(genderSelectbox).click();
		driver.findElement(dobTextbox).sendKeys(dateOfBirth);
		driver.findElement(addressTextbox).sendKeys(address);
		driver.findElement(cityTextbox).sendKeys(city);
		driver.findElement(stateTextbox).sendKeys(state);
		driver.findElement(pinTextbox).sendKeys(pin);
		driver.findElement(phoneTextbox).sendKeys(phone);
		driver.findElement(emailTextbox).sendKeys(emailAddress);
		driver.findElement(passwordTextbox).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class=\"heading3\"]")).getText(),
				"Customer Registered Successfully!!!");
		
		customId= driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), gender);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dateOfBirth);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), address);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), emailAddress);

	}

	@Test
	public void TC_04_Edit_cusomter() {
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(customId);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();

	}

	@Test
	public void TC_04_Delete_customer() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String getrandomEmail() {
		Random rand = new Random();
		return "thuy" + rand.nextInt(9999) + "@gmail.com";
	}
}
