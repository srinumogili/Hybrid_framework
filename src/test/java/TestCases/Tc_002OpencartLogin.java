package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Accountpage;
import pageObjects.Homepage;
import pageObjects.Loginpage;

public class Tc_002OpencartLogin extends Baseclas {
@Test
	 public void verify_Login() {
			//Homepage
	         logger.info("*** Login Started *****");
			 Homepage hp= new Homepage(driver);
			 hp.clickMyAccount();
			 hp.clickLogin();
			 //Loginpage
			 Loginpage login = new Loginpage(driver);
			 login.setemail(p.getProperty("email"));
			 login.setpassword(p.getProperty("password"));
			 login.loginbtn();

             Accountpage acc= new Accountpage(driver);
             Boolean heading= acc.myaccount();
	         Assert.assertTrue(heading);
	         logger.info("****Login successfully****");
}
}