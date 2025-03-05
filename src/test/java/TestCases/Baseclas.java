package TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclas {
	public WebDriver driver;
    public Logger logger;
    public Properties p;
    
    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws IOException {
    	
    	//loading Config.properties file we need write piece of code 
    	
    	FileReader file= new FileReader("./src/test/resources/config.properties");
    	p=new Properties();
    	p.load(file);
    	
    	
    	logger = LogManager.getLogger(Baseclas.class);
    	
    	switch(br.toLowerCase()) {
    	case "chrome" : driver= new ChromeDriver();break;
    	case "edge"   : driver=new EdgeDriver();break;
    	case "firefox": driver= new FirefoxDriver();break;
    	default:System.out.println("invalid browser name...");return;
    	}
    	
    	

    	driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //get the url from property file 
        driver.get(p.getProperty("appurl"));
        driver.manage().window().maximize();
        logger.info("browser launched.......  ");
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
