package wwe.test.base;

import org.apache.log4j.Priority;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import org.apache.log4j.Logger;
import wwe.constants.Constants;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    //    protected WebDriver driver;
    protected Logger logger;

    @BeforeSuite(alwaysRun = true)
    public void beforeAll() {
        logger = Constants.getInstance().logger;
        logger.info("************************** Test Execution Started ************************************");
    }


    @AfterSuite(alwaysRun = true)
    public void logResults(ITestContext context) {
        int total = context.getAllTestMethods().length;
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        logger.info("Total number of testcases : " + total);
        logger.debug("Number of testcases Passed : " + passed);
        logger.error("Number of testcases Failed : " + failed);
        logger.warn("Number of testcases Skipped  : " + skipped);
        logger.info("************************** Test Execution Finished ***********************************");
    }


    @BeforeClass
    protected void setup() {

//        Constants.getInstance().driver.manage().window().maximize();
//        Constants.getInstance().driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    //
//
//    @AfterClass
//    public void wrapUp() {
//        if (Constants.getInstance().driver != null) {
//            Constants.getInstance().driver.close();
//            Constants.getInstance().driver.quit();
//        }
//    }
}
