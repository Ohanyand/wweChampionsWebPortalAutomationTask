package wwe.constants;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import wwe.Authorization.IAuthentication;
import wwe.logging.ConsoleLogger;
import wwe.pages.LoginPage;

public class Constants {

    private static Constants instance;

    public final String WORKING_DIRECTORY = System.getProperty("user.dir");

    public final String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/chromedriver.exe";
//    public final String FIREFOX_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/chromedriver.exe";

    public final Logger logger = new ConsoleLogger();

    public IAuthentication authentication;
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
//        System.setProperty("webdriver.chromedriver.driver", FIREFOX_DRIVER_PATH);
//        ChromeOptions options = new ChromeOptions();
////        options.addArguments("user-agent=\"Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)\"");
//
//        String userAgent ="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36 OPR/60.0.3255.170";
//        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36 OPR/60.0.3255.170";
//        options.addArguments(userAgent);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-java");
//        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36";
//        options.addArguments(userAgent);
//        options.he
        driver = new ChromeDriver(options);
        authentication = new LoginPage();
    }
}
