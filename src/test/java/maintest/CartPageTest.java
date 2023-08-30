package maintest;

import basemethod.BaseMethod;
import org.testng.annotations.Test;

public class CartPageTest extends BaseMethod {



    @Test (groups = "Regression Testing")
    public void cartAddItemTest(){
        startTestMethod().userAddToCartVerify().verifyCart();
    }


}
