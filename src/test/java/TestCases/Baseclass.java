package TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {

    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws IOException {
        // Load config.properties file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        // Initialize Logger
        logger = LogManager.getLogger(Baseclass.class);

        // Setup WebDriver
        if (Boolean.parseBoolean(p.getProperty("useRemoteWebDriver"))) {
            setupRemoteDriver(os, br);
        } else {
            setupLocalDriver(br);
        }

        // Configure Browser
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to Application URL
        driver.get(p.getProperty("Appurl"));
        logger.info("Browser launched and navigated to application URL");
    }

    /**
     * Set up RemoteWebDriver for Selenium Grid execution.
     */
    public void setupRemoteDriver(String os, String br) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        // Set platform dynamically
        if (os.equalsIgnoreCase("windows")) {
            capabilities.setPlatform(Platform.WIN11);
        } else if (os.equalsIgnoreCase("linux")) {
            capabilities.setPlatform(Platform.LINUX);
        } else {
            capabilities.setPlatform(Platform.ANY);
        }

        // Set browser
        capabilities.setBrowserName(br);

        driver = new RemoteWebDriver(new URL(p.getProperty("seleniumGridUrl")), capabilities);
        logger.info("Remote WebDriver initialized for " + br + " on " + os);
    }

    /**
     * Set up local WebDriver for execution on the local machine.
     */
    public void setupLocalDriver(String br) {
        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + br);
        }
        logger.info(br + " browser launched successfully");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed successfully");
        }
    }
}
