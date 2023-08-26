package maintest;

import basemethod.BaseMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseMethod {



    @Test(groups = {"Smoke Testing"})
    public void hoodieHoverTest(){
        startTestMethod().hoodieHoverTest();
    }

    @Test (groups = {"Smoke Testing"})
    public void myAccount(){

        startTestMethod().myAccount();

    }

    @Test (groups = {"Smoke Testing"})
    public void facebookButtonTest(){
        startTestMethod().facebookButtonTest();

    }



    @Test (groups = {"Smoke Testing"})
    public void userCart1Test(){
        startTestMethod().userCart1Test();

    }


    @Test (groups = {"Smoke Testing"})
    public void UserWishlistTest(){
        startTestMethod().UserWishlistTest() ;

    }









}
