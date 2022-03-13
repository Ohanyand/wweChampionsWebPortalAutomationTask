package wwe.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wwe.authorization.IAuthentication;
import wwe.constants.Constants;
import wwe.model.IMainUser;


public class LoginPage extends BasePage implements IAuthentication {

    @FindBy(css = ".right-sidebar-layout__header > div > button")
    private WebElement loginBtn;

    @FindBy(css = "button[data-id='scopely_login']")
    private WebElement scopelyLogin;

    @FindBy(id = "okta-signin-username")
    private WebElement username;

    @FindBy(id = "okta-signin-password")
    private WebElement password;

    @FindBy(id = "okta-signin-submit")
    private WebElement signIn;

    public LoginPage scopelyLogin() {
        this.scopelyLogin.click();
        return this;
    }

    public LoginPage loginForm() {
        this.loginBtn.click();
        return this;
    }


    public LoginPage enterUsername(String username) {
        this.username.sendKeys(username);
        return this;
    }


    public LoginPage enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public void signIn() throws InterruptedException {
        this.signIn.click();
    }



    @Override
    public IMainUser logIn(String username, String password) throws InterruptedException {
        try {
            this.loginForm()
                    .scopelyLogin()
                    .enterUsername(username)
                    .enterPassword(password)
                    .signIn();
        } catch (Exception e) {
            Constants.getInstance().logger.error(e.getMessage());
        }
        Thread.sleep(3000);
        this.closeModalWindow();
        return new UserPage();
    }

}
