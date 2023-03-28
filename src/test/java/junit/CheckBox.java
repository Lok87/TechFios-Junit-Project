package junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://techfios.com/test/107/");
		driver.manage().window().maximize();
		driver.findElement(By.name("allbox")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("todo[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("allbox")).click();
		Thread.sleep(2000);

		driver.quit();

	}

}
