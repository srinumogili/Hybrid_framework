package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.Basepage;

public class Homepage extends Basepage {
 
	WebDriver driver;
	public Homepage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
   @FindBy(xpath="//img[@alt='client brand banner']")
     WebElement logo;
	public void username() {
		username.sendKeys("Admin");
	}
	public void password() {
		password.sendKeys("admin123");
	}
	public void submit() {
		submit.click();
	}
	public boolean logo() {
		return logo.isDisplayed();
	}
}
