package TestCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclas {
	public WebDriver driver;
    public Logger logger;
    
    @BeforeClass
    public void setup() {
    	logger = LogManager.getLogger(Baseclas.class);
    	driver= new ChromeDriver();
    	driver.get("http://localhost:8080/opencart/");
    	driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        logger.info("browser launched sucssfully ");
    }
        @AfterClass
        public void teardown() {
            if (driver != null) {
                driver.quit();
                logger.info("Browser closed successfully");
            }
    }
        public String randomstring() {
    		String randomstring=RandomStringUtils.randomAlphabetic(5);
    		return randomstring;
    	 }
    		public String randomnumber() {
    			String randomnumber=RandomStringUtils.randomNumeric(10);
    			return randomnumber;
    		 }
    		public String randomAlphanumeric() {
    			String randomstring=RandomStringUtils.randomAlphabetic(5);
    			String randomnumber=RandomStringUtils.randomNumeric(10);
    			return (randomstring+"@"+randomnumber);
    		 }
        
    
}
