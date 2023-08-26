package maintest;

import basemethod.BaseMethod;
import org.testng.annotations.Test;

public class AddressesPageTest extends BaseMethod {





    @Test
    public void AddressesPageTest(){
        startTestMethod().myAccount().registerNewAccount().addressesPageButtonTest().changeShippingAddress();
    }
}
