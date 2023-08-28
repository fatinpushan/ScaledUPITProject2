package pages;

import basemethod.BaseMethod;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import report.ExtendReportConfig;
import utility.FakerClass;

import java.io.File;

public class AccountDetailsPage extends BaseMethod {

    WebDriver driver = browser.BrowserClass.getDriver() ;
    Logger log = LogManager.getLogger(AccountDetailsPage.class.getName());

    @FindBy( id = "account_first_name") private WebElement firstName ;
    @FindBy(id = "account_last_name") private WebElement lastName ;
    @FindBy(css = "[value='Save changes']") private WebElement saveChange ;
    @FindBy (linkText = "Addresses") private WebElement addressesPageButton ;
    @FindBy(css = "[class='woocommerce-message']")private WebElement getSavedText ;


    public void changeAccountInfo(){
        extent = report.ExtendReportConfig.getExtentReport() ;

        test = extent.startTest("changeAccountInfo" , "check to see if we can" +
                "change the account username")
                .assignAuthor("Fatin Pushan").assignCategory("Regression Testing").assignCategory("AccountDetailsPage") ;
        log.info("Starting changeAccountInfo ");
        test.log(LogStatus.INFO, "Start up", "Starting up changeAccountInfo");

        FakerClass fakerClass = new FakerClass() ;
        String firstName1 = fakerClass.getFirstName() ;
        String password1 = fakerClass.getPassword() ;



        log.info("Send firstname keys");
        test.log(LogStatus.INFO, "Step 1", "Send firstname keys");
        firstName.sendKeys(firstName1);

        log.info("Send password keys");
        test.log(LogStatus.INFO, "Step 2", "Send password keys");
        lastName.sendKeys(password1);
        log.info("click on save change");
        test.log(LogStatus.INFO, "Step 3", "click on save change");
        saveChange.click()   ;

        try{
            Assert.assertEquals( "Account details changed successfully." ,  getSavedText.getText()   );
            log.info("TEST PASSED ");
            test.log(LogStatus.PASS, "Step 4", "TEST PASSED");
        } catch (AssertionError e) {
            e.printStackTrace();
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "changeAccountInfo has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(test.addScreenCapture(takeScreenshotForExtendReport("hoodieHoverTest")) )) ;
        }


    }









}
