package maintest;

import basemethod.BaseMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseMethod {



    @Test(groups = {"Regression Testing"})
    public void hoodieHoverTest(){
        startTestMethod().hoodieHoverTest();
    }

    @Test (groups = {"Regression Testing"})
    public void myAccount(){

        startTestMethod().myAccount();

    }

    @Test (groups = {"Regression Testing"})
    public void facebookButtonTest(){
        startTestMethod().facebookButtonTest();

    }



    @Test (groups = {"Regression Testing"})
    public void userCart1Test(){
        startTestMethod().userCart1Test();

    }


    @Test (groups = {"Regression Testing"})
    public void UserWishlistTest(){
        startTestMethod().UserWishlistTest() ;

    }




}
