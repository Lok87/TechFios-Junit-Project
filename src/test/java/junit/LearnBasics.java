package junit;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LearnBasics {
	WebDriver driver;

	// by type
	By USER_NAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGN_IN_BUTTON_FIELD = By.xpath("//button[@name='login']");
	By DASHBOARD_HEADER_FIELD = By.xpath("//h2[text()=' Dashboard ']");

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() {

		// Element list

		// webelement type
		/*WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGN_IN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@name='login']"));

		USER_NAME_ELEMENT.clear();
		USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGN_IN_BUTTON_ELEMENT.click();

		WebElement DASHBOARD_HEARDER_ELEMENT = driver.findElement(By.xpath("//h2[text()=' Dashboard ']"));
		Assert.assertTrue("Dashboard page is not available", DASHBOARD_HEARDER_ELEMENT.isDisplayed());*/

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGN_IN_BUTTON_FIELD).click();
		Assert.assertTrue("Dashboard page is not available", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());

	}

	@Test
	public void negLoginTest() {

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123weq");
		driver.findElement(SIGN_IN_BUTTON_FIELD).click();
		Assert.assertTrue("Dashboard page is not available", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
	}

}

