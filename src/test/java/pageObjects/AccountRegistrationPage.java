package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.Basepage;

public class AccountRegistrationPage extends Basepage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemailId;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelphone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconfpassword;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement chkpolicy;
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btncontinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confmessage;
	
	public void enterfirstname(String fname) {
		txtfirstname.sendKeys(fname);
		
	}
	public void enterlastname(String lname) {
		txtlastname.sendKeys(lname);
	}
	public void enteremailid(String email) {
		txtemailId.sendKeys(email);
	}
	public void entertelephoneno(String telno) {
		txtTelphone.sendKeys(telno);
	}
	public void enterpassword(String password) {
		txtpassword.sendKeys(password);
	}
	public void enterconfrompassword(String conpassword) {
		txtconfpassword.sendKeys(conpassword);
	}
	public void clickcheckbox() {
		chkpolicy.click();
	}
	public void ClickContinue(){
		btncontinue.click();
	}
	public String confomessage() {
		try {
		return(confmessage.getText());
	}catch (Exception e) {
		return(e.getMessage());
	}
}
}
