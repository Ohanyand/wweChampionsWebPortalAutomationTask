package wwe.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wwe.model.IMainUser;

import java.time.Duration;

public class UserPage extends BasePage implements IMainUser {

    @FindBy(css = "div[data-id='account_profile_settings_show_button']")
    private WebElement accountSettingBtn;

    @FindBy(css = "li[data-id='account_settings_Change Avatar']")
    private WebElement changeAvatarBtn;

    @FindBy(css = "div[data-id='select_26_avatar']")
    private WebElement freeAvatar;

    @FindBy(css = "button[data-id='avatar_change_apply_button']")
    private WebElement applyAvatarChangesBtn;

    @FindBy(css = "p[data-id='avatar_select_remove_frame']")
    private WebElement removeFrameBtn;

    @FindBy(css = "li[data-id='account_settings_Logout']")
    private WebElement logOutBtn;

    @Override
    public void logOut() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(accountSettingBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logOutBtn)).click();
    }

    @Override
    public void changeAvatar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(accountSettingBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(changeAvatarBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(freeAvatar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(applyAvatarChangesBtn)).click();
    }

    @Override
    public void changeFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(accountSettingBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(changeAvatarBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(removeFrameBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(applyAvatarChangesBtn)).click();
    }
}
