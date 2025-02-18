package Testng_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataProviderDemo {
	WebDriver driver;

	@BeforeClass
	void Setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "dp")
	void login(String email, String pwd) {
		driver.findElement(By.xpath("//input[@name='username']")).clear();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		boolean isBrandDisplayed = false;
		try {
			WebElement brand = driver.findElement(By.xpath("//img[@alt='client brand banner']"));
			isBrandDisplayed = brand.isDisplayed();
		} catch (Exception e) {
			isBrandDisplayed = false;
		}

		if (isBrandDisplayed) {
			driver.navigate().back();

			Assert.assertTrue(isBrandDisplayed, "Login successful, brand banner is displayed");

		} else {
			Assert.fail();
		}

	}

	@AfterClass
	void teardown() {
		driver.quit();
	}

	@DataProvider(name = "dp")
	Object[][] logindata() {

		Object[][] data = { { "Admin", "admin123" }, { "sri", "sri@123" }, { "Admin", "admin@123" },
				{ "Admin", "Sdmin123" } };
		return data;
	}

}
