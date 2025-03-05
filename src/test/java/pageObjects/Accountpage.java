package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.Basepage;

public class Accountpage extends Basepage {

	public Accountpage(WebDriver driver ) {
		super(driver);
}

	@FindBy (xpath="//h2[normalize-space()='My Account']")
	WebElement pageheading;

	@FindBy (xpath="//a[@class='list-group-item'][text()='Logout']")
	WebElement Clicklogout;


	public Boolean myaccount() {
		try {
		return(pageheading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	public void logout() {
		Clicklogout.click();
	}
}

