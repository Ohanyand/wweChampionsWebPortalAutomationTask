package wwe.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import wwe.constants.Constants;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;

    protected String url = "https://wwechampions.com/";

    @FindBy(className = "avatar-select-close")
    private WebElement modalCloseBtn;

    public BasePage() {
        this.init(Constants.getInstance().driver);
    }

    public void closeModalWindow() {
        try {
            this.modalCloseBtn.click();

        }catch (NoSuchElementException e){

        }
    }



    private void init(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.driver.get(url);
//        this.driver.get("https://id.scopely.com/");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

}
