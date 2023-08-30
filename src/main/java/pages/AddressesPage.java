package pages;

import basemethod.BaseMethod;
import com.microsoft.playwright.S;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.FakerClass;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class AddressesPage extends BaseMethod {

    WebDriver driver = browser.BrowserClass.getDriver() ;

   Logger log = LogManager.getLogger(BaseMethod.class.getName());

    @FindBy(id = "shipping_first_name") private WebElement firstName ;
    @FindBy (id = "shipping_last_name") private WebElement lastName ;
    @FindBy(id = "shipping_address_1") private WebElement shippingAddress ;
    @FindBy(id = "shipping_address_2") private WebElement apartmentOptional ;
    @FindBy(id = "shipping_city") private WebElement city ;
    @FindBy(id = "shipping_postcode") private WebElement zipCode ;
    @FindBy(css = "[class='select2-selection__arrow']") private WebElement country ;
    @FindBy(css = "[class='select2-search__field']") private WebElement countryField ;
    @FindBy(id = "select2-shipping_state-container") private WebElement state ;
    @FindBy(css = "[class='select2-search__field']") private WebElement stateField ;
    @FindBy(css = "[name='save_address']") private WebElement saveAddressButton ;
    @FindBy(xpath = "//*[@class='u-column2 col-2 woocommerce-Address']/address") private WebElement getVerifyNewChangeShippingAddressText ;
    List<WebElement> addShippingButton = driver.findElements(By.linkText("Add")) ;



public MyAccountPage changeShippingAddress(){
    FakerClass fakerClass = new FakerClass() ;


    extent = report.ExtendReportConfig.getExtentReport() ;

    test = extent.startTest("changeShippingAddress" , "check to see if we can edit shipping address")
            .assignAuthor("Fatin Pushan").assignCategory("Regression Testing").assignCategory("AddressesPage") ;
    log.info("Starting changeShippingAddress ");
    test.log(LogStatus.INFO, "Start up", "Starting changeShippingAddress");

test.log(LogStatus.INFO, "Step 1" , "Click on edit");
    log.info("Click on edit");
    addShippingButton.get(1).click();

    test.log(LogStatus.INFO, "Step 2" , "Send first name field");
    log.info("Send first name field");
    String getFirstName = fakerClass.getFirstName() ;
    firstName.sendKeys(getFirstName);

    test.log(LogStatus.INFO, "Step 3" , "Send last name field");
    log.info("Send last name field");
    String getLastName = fakerClass.getLastName() ;
    lastName.sendKeys(getLastName);

    test.log(LogStatus.INFO, "Step 4" , "Send shippingAddress name field");
    log.info("Send shippingAddress name field");
    String getShippingAddress = fakerClass.getAddress() ;
    shippingAddress.sendKeys(getShippingAddress);

    test.log(LogStatus.INFO, "Step 5" , "Send apartment name field");
    log.info("Send apartment name field");
    String getApartmentOptional = fakerClass.getZipCode() ;
    apartmentOptional.sendKeys(getApartmentOptional);

    test.log(LogStatus.INFO, "Step 6" , "Send city name field");
    log.info("Send city name field");
    String getCity =fakerClass.getCity() ;
    city.sendKeys(getCity);

    test.log(LogStatus.INFO, "Step 7" , "Send zipCode field");
    log.info("Send zipCode field");
    String getZipCode =fakerClass.getZipCode() ;
    zipCode.sendKeys(getZipCode);

    test.log(LogStatus.INFO, "Step 8" , "Click on country and select US");
    log.info("Click on country and select US");
    country.click();
    String javascriptEnter = Keys.chord(Keys.ENTER);
    countryField.sendKeys("United States (US)"+ javascriptEnter)  ;

    test.log(LogStatus.INFO, "Step 9" , "Click on state and select US");
    log.info("Click on state and select US");
    state.click();
    stateField.sendKeys("New York" + javascriptEnter);

    test.log(LogStatus.INFO, "Step 10" , "Click on save address");
    log.info("Click on save address");
    saveAddressButton.click();


    String expectedOutput = getFirstName + " " + getLastName + "\n" +
            getShippingAddress + "\n" +
            getApartmentOptional + "\n" +
            getCity + ", NY " + getZipCode ;

try {
    Assert.assertEquals(getVerifyNewChangeShippingAddressText.getText(),expectedOutput);
    log.info("changeShippingAddress Has passed");
    test.log(LogStatus.PASS, "PASSED" , "changeShippingAddress Has passed");
} catch (AssertionError e) {
    e.printStackTrace();
    log.error("Test Has Failed \"changeShippingAddress\"");
    test.log(LogStatus.FAIL, "FAILED" , "\"Test Has Failed \\\"changeShippingAddress\\\"\""
            + test.addScreenCapture(takeScreenshotForExtendReport("changeShippingAddress") ));

}


    return PageFactory.initElements(driver,MyAccountPage.class) ;
}





}
