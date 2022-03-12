package wwe.test;

import org.testng.annotations.Test;
import wwe.constants.Constants;
import wwe.model.IMainUser;
import wwe.test.base.BaseTest;


public class UserTest extends BaseTest {


    @Test(description = "WWEChampions login and change avatar of the user")
    public void changeAvatarTest() throws InterruptedException {

        // Login to wweChampions web portal
        IMainUser user = Constants.getInstance().authentication.logIn("ohanyand21@gmail.com", "Davit@2002");

        user.changeAvatar();

        user.logOut();
    }

    @Test(description = "WWEChampions login and change frame of the user")
    public void changeFrameTest() throws InterruptedException {

        // Login to wweChampions web portal
        IMainUser user = Constants.getInstance().authentication.logIn("ohanyand21@gmail.com", "Davit@2002");

        // Change frame (Removing frame as there is no free frame :D)
        user.changeFrame();

        user.logOut();
    }
}
