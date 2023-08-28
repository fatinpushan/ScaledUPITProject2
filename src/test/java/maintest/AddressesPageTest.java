package maintest;

import basemethod.BaseMethod;
import org.testng.annotations.Test;

public class AddressesPageTest extends BaseMethod {





    @Test (groups = {"Regression Testing"})
    public void changeShippingAddress(){
        startTestMethod().myAccount().registerNewAccount().addressesPageButtonTest().changeShippingAddress();
    }






}
