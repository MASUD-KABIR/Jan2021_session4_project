package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {
//	Automate the following test case:
//
//		Scenario: CRM -> Customers -> Add Contact - Add contact and validate contact added in List Contacts
//		Open Browser and go to site http://techfios.com/billing/?ng=admin/
//		Enter username:  demo@techfios.com 
//		Enter password: abc123
//		Click login button
//		Click on Customers button in the Side Navigation
//		Click on Add Customer
//		Fill in the Add Customer Form
//		Click submit
//		Go to CRM -> List Customer Page
//		Search for the new Customer in the search field
//		Validate contact Customer ​

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void validateContactAddedTest() throws InterruptedException {

		WebElement USER_NAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASS_WORD_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGNIN_BUTTON_FIELD_ELEMENT = driver.findElement(By.xpath("//button[@type='submit']"));

		USER_NAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		PASS_WORD_FIELD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_FIELD_ELEMENT.click();

//		WebElement DASHBOARD_FIELD_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));

		WebElement CUSTOMER_FIELD_ELEMENT = driver.findElement(By.xpath("//span[contains(text(), 'Customers')]"));
		CUSTOMER_FIELD_ELEMENT.click();

		// Creating object for explicit wait to locate Add Customer field

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(), 'Add Customer')]"))));

		WebElement ADD_CUSTOMER_FIELD_LOCATOR_ELEMENT = driver.findElement(By.xpath("//a[contains(text(), 'Add Customer')]"));
		ADD_CUSTOMER_FIELD_LOCATOR_ELEMENT.click();
		
		WebElement ACCOUNT_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@name='account']"));
		WebElement EMAIL_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement PHONE_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@name='phone']"));
		WebElement ADDRESS_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@name='address']"));
		WebElement CITY_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@name='city']"));
		WebElement STATE_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@name='state']"));
		WebElement ZIP_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@name='zip']"));
		WebElement SAVE_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@id='submit']"));
		
		Thread.sleep(5000);
		WebElement LIST_CUSTOMERS_FIELD_ELEMENT = driver.findElement(By.xpath("//a[contains(text(), 'List Customers')]")); 
//		DASHBOARD_FIELD_ELEMENT.isDisplayed();

		Thread.sleep(2000);

		// Fill in the Add Customer Form
		ACCOUNT_FIELD_ELEMENT.sendKeys("January2021");
		EMAIL_FIELD_ELEMENT.sendKeys("January2021@gmail.com");
		PHONE_FIELD_ELEMENT.sendKeys("202120212021");
		ADDRESS_FIELD_ELEMENT.sendKeys("2741 E Belt Line Rd");
		CITY_FIELD_ELEMENT.sendKeys("Carrollton");
		STATE_FIELD_ELEMENT.sendKeys("TX");
		ZIP_FIELD_ELEMENT.sendKeys("75006");
		SAVE_BUTTON_ELEMENT.click();

		
		LIST_CUSTOMERS_FIELD_ELEMENT.click();
	}

}
