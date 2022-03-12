package wwe.test;

import org.testng.annotations.Test;
import wwe.constants.Constants;
import wwe.model.IMainUser;
import wwe.test.base.BaseTest;


public class UserTest extends BaseTest {


    @Test(description = "WWEChampions login and change avatar of the user")
    public void changeAvatarTest() {

       IMainUser user = Constants.getInstance().authentication.logIn("ohanyand21@gmail.com", "Davit@2002");
//       IMainUser user1 = Constants.getInstance().authentication.logIn("ohanyand21@gmail.com", "Davit@2002");


    }


}
