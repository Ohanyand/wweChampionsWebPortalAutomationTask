package wwe.constants;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import wwe.authorization.IAuthentication;
import wwe.logging.ConsoleLogger;
import wwe.pages.LoginPage;

public class Constants {

    private static Constants instance;

    public final String WORKING_DIRECTORY = System.getProperty("user.dir");
    // These for win10
    public final String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/chromedriver.exe";
    public final String FIREFOX_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/geckodriver.exe";

    // These for ubuntu
    public final String CHROME_DRIVER_PATH_UBUNTU = WORKING_DIRECTORY + "/src/test/resources/drivers/ubuntu/chromedriver";
    public final String FIREFOX_DRIVER_PATH_UBUNTU = WORKING_DIRECTORY + "/src/test/resources/drivers/geckodriver.exe";

    public final Logger logger = new ConsoleLogger();

    public IAuthentication authentication;
    public String url = "https://wwechampions.com/";

    public WebDriver driver;

    public static Constants getInstance() {
        if (instance == null) {
            instance = new Constants();
            instance.init();
        }

        return instance;
    }

    private Constants() {
    }

    protected void init() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        /**
         *  These for implementing tests on FireFox and Ubuntu
         *
         * System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
         * System.setProperty("webdriver.gecko.driver", CHROME_DRIVER_PATH_UBUNTU);
         * System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH_UBUNTU);
         */


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-extensions");

        driver = new ChromeDriver(options);
//        driver = new FirefoxDriver(); // use for FireFox
        authentication = new LoginPage();
    }

}
