package junit;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLocators {
WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://objectspy.space/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testLocators() {
		
		driver.findElement(By.name("firstname")).sendKeys("Selenium");
		driver.findElement(By.id("sex-1")).click();
		
		//upload file if the tag is other than INPUT need to use a class called ROBOT
		//upload file if the tag is INPUT
		driver.findElement(By.id("photo")).sendKeys("C:\\Users\\shiha\\OneDrive\\Desktop\\Techfios Class\\Selenium\\Selenium\\Session 1.pptx");
		driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
		driver.navigate().back();
		//driver.findElement(By.partialLinkText("Product")).click();
		
		//CSS Selector
		driver.findElement(By.cssSelector("input#exp-5")).click();
//		driver.findElement(By.cssSelector("input[value='Automation Tester']")).click();
		driver.findElement(By.cssSelector("input[value='Automation Tester'][id='profession-1']")).click();
//		driver.findElement(By.cssSelector("a[href$='http://techfios.com/api-prod/api/']")).click();
		
		//xpath
		//absloute 
		driver.findElement(By.xpath("html/body/div/div[2]/div[2]/form/div[10]/input")).sendKeys("is fun");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("is fun");
//		driver.findElement(By.xpath("//input[@name='Password' and @type='password']")).sendKeys("is fun");
//		driver.findElement(By.xpath("//strong[text()='Link Test : New Page']")).click();
		driver.findElement(By.xpath("//strong[contains(text(), 'Link Test : New Page')]")).click();
		driver.findElement(By.xpath("//input[@id=\"tool-2\"]")).click();
		
		
		
	}

	//@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}

