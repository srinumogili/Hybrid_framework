package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;

public class TC_001opencartRegistartion extends Baseclas{

	@Test(groups={"Sanity","Master"})
	 public void homepage() throws InterruptedException{
		try {
		 Homepage hp= new Homepage(driver);
		 hp.clickMyAccount();
		 logger.info("Click on my account registration");
		 hp.clickRegister();

		 AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		 regpage.enterfirstname(randomstring().toUpperCase());
		 logger.info("***enter Registration details***");
		 regpage.enterlastname(randomstring().toUpperCase());
		 regpage.enteremailid(randomstring()+"@gmail.com");
		 regpage.entertelephoneno(randomnumber());
		 String password= randomAlphanumeric();
		 regpage.enterpassword(password);
		 regpage.enterconfrompassword(password);
		 regpage.clickcheckbox();
		 regpage.ClickContinue();
		 String confrommessage= regpage.confomessage();
		 if(confrommessage.equals("Your Account Has Been Created!")) {
			 Assert.assertTrue(true);
		 }
		 else {
			 Assert.assertTrue(false);
			 logger.debug("debugging the code");
			 logger.error("Test Failed");
		 }

		}
		 catch (Exception e)
		 {
			 Assert.fail();

		 }
		}
		}

