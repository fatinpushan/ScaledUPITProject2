package pages;

import basemethod.BaseMethod;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BaseMethod {

    WebDriver driver = browser.BrowserClass.getDriver() ;
    Logger log = LogManager.getLogger(CartPage.class.getName());

    @FindBy (linkText = "Hoodie") private WebElement getTextForHoodie ;

    public void verifyCart(){

        extent = report.ExtendReportConfig.getExtentReport() ;
        test = extent.startTest("verifyCart", "Testing to see if we can add an item to a cart and it is save correctly")
                .assignAuthor("Fatin Pushan").assignCategory("CartPage") ;

        test.log(LogStatus.INFO, "Start Up", "Starting test \"verifyCart\"");
        log.info("Create class");
        HomePage homePage = new HomePage() ;


        try {
            log.info("TEST PASSED \"verifyCart\"");
        test.log(LogStatus.PASS, "PASSED", "TEST PASSED \"verifyCart\"");
            Assert.assertEquals(HomePage.getTextForCartVerify(),getTextForHoodie.getText());
        } catch (AssertionError e) {
            e.printStackTrace();
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "verifyCart has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(test.addScreenCapture(takeScreenshotForExtendReport("verifyCart")) )) ;

        }

    }

}
