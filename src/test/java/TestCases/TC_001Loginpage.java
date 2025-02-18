package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;

public class TC_001Loginpage extends Baseclass{
	@Test
	public void loginpage() {
	
		Homepage hp= new Homepage(driver);
		logger.info("import Homepage");
		hp.username();
		logger.info("enter username");
		hp.password();
		logger.info("enter password");
		hp.submit();
		logger.info("click the button");
		
		/*boolean logodispalyed=hp.logo();
		Assert.assertTrue(logodispalyed,"logo not displayed,login failed!");
		//validating the Title 
        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(actualTitle, expectedTitle,"Page title does not match!");

        logger.info("Login test passed successfully");
		
		}
		catch(Exception e){
			logger.error("test failed"+e.getMessage());
			logger.debug("Debug logs");
			Assert.fail("Test case failed due to this exception"+e.getMessage());*/
		
	}
	
}
