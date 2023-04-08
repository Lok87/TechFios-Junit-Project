package junit;

import java.util.concurrent.TimeUnit;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LoginTestCRM {

		
		WebDriver driver;
		
		@Before
		public void init() {
			
//			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.get("https://www.techfios.com/billing/?ng=login/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		
		@Test
		public void loginTest() {
			
			WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement SIGN_IN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@name='login']"));
			
			
			By USER_NAME_FIELD = By.xpath("//input[@id='username']");
			By PASSWORD_FIELD = By.xpath("//input[@id='password']");
			By SIGN_IN_BUTTON_FIELD = By.xpath("//button[@name='login']");
			By DASHBOARD_HEADER_FIELD = By.xpath("//h2[text()=' Dashboard ']");
			
//			USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
			driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
			driver.findElement(PASSWORD_FIELD).sendKeys("abc1235");
			driver.findElement(SIGN_IN_BUTTON_FIELD).click();
			
			
			boolean pageTitleDisplay;
			try {
				
				WebElement DASHBOARD_HEARDER_ELEMENT = driver.findElement(By.xpath("//h2[text()=' Dashboard ']"));
				pageTitleDisplay = true;
				
			}catch(NoSuchElementException e) {
				pageTitleDisplay = false;
				e.printStackTrace();
			}
			
			/*WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));*/
			
			
//			Assert.assertTrue("Dashboard page not found", DASHBOARD_HEARDER_ELEMENT.isDisplayed());
			Assert.assertTrue("Dashboard page not found", pageTitleDisplay);
			
			
			
			
			
		}
		

	}

