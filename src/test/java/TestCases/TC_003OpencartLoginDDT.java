package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Accountpage;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import utilites.DataProviders;

public class TC_003OpencartLoginDDT extends Baseclas {
    @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email,String Pwd, String exp) {

    logger.info("*******Starting TC_003_LoginDDt****8");
    try {
    	//Homepage
        logger.info("*** Login Started *****");
		 Homepage hp= new Homepage(driver);
		 hp.clickMyAccount();
		 hp.clickLogin();
		 //Loginpage
		 Loginpage login = new Loginpage(driver);
		 login.setemail(email);
		 login.setpassword(Pwd);
		 login.loginbtn();

        Accountpage acc= new Accountpage(driver);
        boolean targetPage=acc.myaccount();


        if(exp.equalsIgnoreCase("valid")) {
        	if(targetPage) {
        		logger.info(" Login successful for valid credentials: " + email);
        		acc.logout();
        		Assert.assertTrue(true);
        	}
        	else
        	{
        		logger.error("❌ Expected successful login, but login failed for: " + email);
                Assert.fail("Test Failed: Expected successful login but login failed.");

        	}
        }
        	if(exp.equalsIgnoreCase("invalid")) {
            	if(!targetPage) {
            		logger.info("✅ Login failed as expected for invalid credentials: " + email);

            		Assert.assertTrue(true);
            	}
            	else
            	{
            		logger.error("❌ Expected failed login, but login was successful for: " + email);
                    acc.logout();
                    Assert.fail("Test Failed: Expected login failure but login was successful.");
            	}
        	}

        	}catch(Exception e)
        	{
        		 logger.error("❌ Exception occurred during login test: " + e.getMessage());
                 Assert.fail("Test Failed due to an exception.");
        	}
        logger.info("*****Finished TC_003_LoginDDT****");
	}

}
