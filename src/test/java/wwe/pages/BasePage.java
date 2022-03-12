package wwe.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import wwe.constants.Constants;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.init(Constants.getInstance().driver);
    }

    public BasePage(WebDriver driver) {
        this.init(driver);
    }

    private void init(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
//        this.driver.get("https://wwechampions.com/");
        this.driver.get("https://id.scopely.com/");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

}
