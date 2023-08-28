package maintest;

import basemethod.BaseMethod;
import org.testng.annotations.Test;

public class AccountDetailsPageTest extends BaseMethod {




    @Test (groups = {"Regression Testing"})
    public void changeAccountInfoTest(){

        startTestMethod().myAccount().registerNewAccount() .accountDetailsPageButtonTest().changeAccountInfo() ;




    }
}
