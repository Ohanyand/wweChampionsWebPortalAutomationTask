package wwe.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wwe.Authorization.IAuthentication;
import wwe.constants.Constants;
import wwe.model.IMainUser;

import java.util.Random;


public class LoginPage extends BasePage implements IAuthentication {

//    @FindBy(css = ".right-sidebar-layout__header > div > button")
//    private WebElement loginBtn;

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

//    public LoginPage loginForm() {
//        this.loginBtn.click();
//        return this;
//    }



    public LoginPage enterUsername(String username) throws InterruptedException {
        Random rand = new Random();
        Thread.sleep(rand.nextInt(300));

        for (char ch: username.toCharArray()) {
            this.username.sendKeys(ch+"");
            Thread.sleep(rand.nextInt(300));
        }

        return this;
    }


    public LoginPage enterPassword(String password) throws InterruptedException {
        Random rand = new Random();
        Thread.sleep(rand.nextInt(300));

        for (char ch: password.toCharArray()) {
            this.password.sendKeys(ch+"");
            Thread.sleep(rand.nextInt(300));
        }
        Thread.sleep(rand.nextInt(1000) + 500);
        this.password.sendKeys(Keys.ENTER);
//        this.password.submit();
//                sendKeys(Keys.ENTER);

        return this;
    }

    public void signIn() throws InterruptedException {
        Thread.sleep(new Random().nextInt(300));
        this.signIn.click();
    }

    @Override
    public IMainUser logIn(String username, String password) {
        try {
            this
//                .loginForm()
//                .scopelyLogin()
                .enterUsername(username)
                .enterPassword(password);
//                .signIn();
        } catch(Exception e) {
            Constants.getInstance().logger.error(e.getMessage());
        }

        return new UserPage();
    }
}
