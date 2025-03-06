package TestCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclas {
	public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups= {"Regression","Master","Sanity"})
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws IOException {

    	//loading Config.properties file we need write piece of code

    	FileReader file= new FileReader("./src/test/resources/config.properties");
    	p=new Properties();
    	p.load(file);


    	logger = LogManager.getLogger(Baseclas.class);

    	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();

			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);

			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}

			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}

			driver=new RemoteWebDriver(new URL("http://192.168.1.22:4444"),capabilities);
		}


		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
    	switch(br.toLowerCase()) {
    	case "chrome" : driver= new ChromeDriver();break;
    	case "edge"   : driver=new EdgeDriver();break;
    	case "firefox": driver= new FirefoxDriver();break;
    	default:System.out.println("invalid browser name...");return;
    	}
		}

    	driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //get the url from property file
        driver.get(p.getProperty("appurl"));
        driver.manage().window().maximize();
        logger.info("browser launched.......  ");
    }
        @AfterClass(groups= {"Regression","Master","Sanity"})
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

    		public String captureScreen(String tname) throws IOException {

    			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

    			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

    			String targetFilePath=System.getProperty("user.dir")+"\\screenShots\\" + tname + "_" + timeStamp + ".png";
    			File targetFile=new File(targetFilePath);

    			sourceFile.renameTo(targetFile);

    			return targetFilePath;

    		}


}
