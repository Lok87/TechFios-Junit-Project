package junit;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class LearnDropdown {
	WebDriver driver;

	// storing element on By type
	By USERNAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By SIGNIN_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");
	By CUSTOMERS_MENU_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
	By ADD_CUSTOMERS_MENU_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
	By ADD_CONTACT_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5");
	By FULL_NAME_FIELD = By.xpath("//*[@id=\"account\"]");
	By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@id='cid']");

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
		
		driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_FIELD).click();
		
//		Assert.assertTrue("Page not found!!!", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
//		Assert.assertEquals("Page not found!!", "Dashboard- iBilling", driver.getTitle());

		/*String dashboardHeaderText = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
		System.out.println(dashboardHeaderText);
		Assert.assertEquals("Page not found!!", "Dashboard", dashboardHeaderText);*/
		Assert.assertEquals("Dashboard page not found!!", "Dashboard", driver.findElement(DASHBOARD_HEADER_FIELD).getText());
		
	}
	
	@Test
	public void testDropdown() {
		
		loginTest();
		
		driver.findElement(CUSTOMERS_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMERS_MENU_FIELD).click();
		Assert.assertEquals("Add Contact page not found", "Add Contact", driver.findElement(ADD_CONTACT_HEADER_FIELD).getText());
		
		driver.findElement(FULL_NAME_FIELD).sendKeys("Techfios");
		
		Select sel = new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
		sel.selectByVisibleText("Tesla");
		
		
	}
}
