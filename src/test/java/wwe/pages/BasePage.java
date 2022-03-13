package wwe.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import wwe.constants.Constants;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;


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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

}
