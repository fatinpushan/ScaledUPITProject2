package pages;

import basemethod.BaseMethod;
import com.microsoft.playwright.W;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import jdk.dynalink.linker.LinkerServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePage extends BaseMethod {


    private WebDriver driver = browser.BrowserClass.getDriver();
    Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(linkText = "My Account" ) private WebElement myAccount ;
    @FindBy(css= "[class='entry-title']") private WebElement getMyAccountText ;
    @FindBy(linkText = "Wishlist") private WebElement userWishlist ;
    @FindBy(css = "[class='entry-title']") private WebElement getTitle ;
    @FindBy(linkText = "Cart") private WebElement userCart1 ;
    @FindBy(css = "[class='fa fa-facebook']") private WebElement facebookPage ;
    @FindBy(css = "[class='fa fa-instagram']") private WebElement instagramPage ;
    @FindBy(css = "[class='fa fa-camera-retro']") private WebElement snapchat ;
    @FindBy(id = "wp-block-search__input-1") private WebElement searchProductsField ;
    @FindBy(css = "[type='submit']") private WebElement getSearchProductsFieldClickButton ;
    @FindBy(css = "[class='fa fa-shopping-cart']") private WebElement userShoppingCart2 ;
    @FindBy(css = "[class='custom-logo']") private WebElement scaledUPITLogo ;
    @FindBy(xpath = "//*[@id='menu-item-301']/a") private WebElement clothingHoverButton ;
    @FindBy(xpath = "//*[@id='menu-item-309']/a") private WebElement hoodieHoverButton ;
    @FindBy(xpath = "//*[@id='menu-item-310']/a") private WebElement tshirtHoverButton ;
    @FindBy(css = "[class='woocommerce-products-header__title page-title']") private WebElement getHoodieTitle ;
    @FindBy(xpath = "//*[@class='at-cat-color-wrap-17']/div/h2") private WebElement scrollToElement ;
    @FindBy(css = "[class='added_to_cart wc-forward']") private WebElement waitForItemToBeAdded ;
    List<WebElement> getTextForCartVerify = driver.findElements(By.xpath("//*[@id='content']/aside/div[2]/div/div/div/ul/li/a/h2")) ;
    List<WebElement> addItemToCart = driver.findElements(By.xpath("//*[@data-product_id='181']")) ;


    static String TextForCartVerify ;
    public static   String getTextForCartVerify(){
        return TextForCartVerify ;
    }




    public CartPage userAddToCartVerify(){
        extent = report.ExtendReportConfig.getExtentReport() ;
        test = extent.startTest("userAddToCartVerify", "Testing to see if we can add an item to a cart")
                .assignAuthor("Fatin Pushan").assignCategory("HomePage") ;

        log.info("String test \"userAddToCartVerify\"");
        test.log(LogStatus.INFO, "Start Up", "Starting test \"userAddToCartVerify\"");

        test.log(LogStatus.INFO, "Step 1" , "Scroll to element");
        log.info("Scroll to element");
        scrollToElement(scrollToElement);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)) ;

        test.log(LogStatus.INFO, "Step 2" , "Click on add cart");
        log.info("Click on add cart");
        addItemToCart.get(1).click();

        TextForCartVerify =  getTextForCartVerify.get(5).getText() ;

        test.log(LogStatus.INFO, "Step 3" , "Wait for element to be there");
        log.info("Wait for element to be there");
        WebElement waitForCartToBeAdded = wait.until(ExpectedConditions.visibilityOf(waitForItemToBeAdded)) ;

        test.log(LogStatus.INFO, "Step 4" , "Click on chart button");
        log.info("Click on chart button");
        waitForCartToBeAdded.click();


        // the full code for this test will be done in the cart page class
        return PageFactory.initElements(driver, CartPage.class) ;
    }


    public HoodiesPage hoodieHoverTest(){
        extent = report.ExtendReportConfig.getExtentReport() ;

        test = extent.startTest("hoodieHoverTest", "Test to see if we can hover over clothing and then move to hoodie and click")
                .assignAuthor("Fatin Pushan").assignCategory("Regression Testing").assignCategory("HomePageTEST") ;
        log.info("Starting hoodieHoverTest ");
        test.log(LogStatus.INFO, "Start up", "Starting up HoodieHoverTest");

        log.info("Hover over clothing button");
        test.log(LogStatus.INFO, "Step 1", "Hover over clothing button");
        hoverOverElement(driver,clothingHoverButton ) ;

        log.info("Hover over hoodie button and click on it");
        test.log(LogStatus.INFO, "Step 2", "Hover over hoodie button and click on it");
        hoverOverElementAndClick(driver,hoodieHoverButton );

        log.info("Test to see if the actual value is the same as the expected value \"Hoodies\" ");
        test.log(LogStatus.INFO, "Step 3", "Test to see if the actual value is the same as the expected value \"Hoodies\" ");


        try {
            Assert.assertEquals(getHoodieTitle.getText(), "Hoodies");
        } catch (AssertionError e) {
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "hoodieHoverTest has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(test.addScreenCapture(takeScreenshotForExtendReport("hoodieHoverTest")) )) ;



            throw new RuntimeException("Test Has Failed during assertion") ;
        }


        log.info("Test has been completed successfully");
        test.log(LogStatus.PASS, "Step 4", "Test has been completed successfully");

        test.log(LogStatus.INFO, "Screenshot", test.addScreenCapture(takeScreenshotForExtendReport("hoodieHoverTest")));

        return PageFactory.initElements(driver, HoodiesPage.class) ;
    }


    public void facebookButtonTest(){
        extent =  report.ExtendReportConfig.getExtentReport() ;

        test = extent.startTest("facebookButtonTest", "Test to see if the Facebook button works correctly" )
                .assignAuthor("Fatin Pushan").assignCategory("Regression Testing") .assignCategory("HomePageTEST") ;

        test.log(LogStatus.INFO, "Start Up", "HomePage Start Up"     );
        test.log(LogStatus.INFO, "Step 1" , "Navigating to Home Page of Scaled Upit"     );
        test.log(LogStatus.PASS, "Step 2" , "Clicked on the \\\"facebook\\\" button"     );



        log.info("Starting facebookButtonTest");

        log.info("Click on the facebook button");
        facebookPage.click();

        switchToNewWindow(driver) ;

        String facebookText =  driver.findElement(By.cssSelector("[class='_cqp']")).getText() ;

        try {

            Assert.assertEquals(facebookText , "Log into Facebook");
        } catch (AssertionError e) {
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "Test has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(takeScreenshotForExtendReport("facebookButtonTest")));
            throw new RuntimeException("Test Has Failed during assertion") ;
        }


        test.log(LogStatus.INFO, "SCREEN", test.addScreenCapture(takeScreenshotForExtendReport("facebookButtonTest")));
        driver.switchTo().window( switchToCurrentWindow() ) ;

        log.info("facebookButtonTest passed successful");
    }





    public CartPage userCart1Test(){

        extent = report.ExtendReportConfig.getExtentReport() ;

        test = extent.startTest("userCart1Test" , "Testing to see if the cart button works properly")
                .assignAuthor("Fatin Pushan").assignCategory("Regression Testing").assignCategory("HomePageTEST")      ;

        test.log(LogStatus.INFO, "SetUp" , "Starting cart1Test" );
        log.info("Starting cart1Test");

        test.log(LogStatus.INFO, "Step 1" , "Click on user cart on the top of the page" );
        log.info("Click on user cart on the top of the page");
        userCart1.click();

        test.log(LogStatus.INFO, "Step 2" , "Checking to see if the actual value of cart page title is equal to the expected \"Cart\"" );
        log.info("Checking to see if the actual value of cart page title is equal to the expected \"Cart\"");


        try {

            Assert.assertEquals(getTitle.getText(), "Cart");
        } catch (AssertionError e) {
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "Test has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(takeScreenshotForExtendReport("userCart1Test")));
            throw new RuntimeException("Test Has Failed during assertion") ;
        }


        log.info("userCart1Test test complete");
        test.log(LogStatus.PASS, "Step 3" , "Test has finished");

        test.log(LogStatus.INFO, "Screenshot", test.addScreenCapture(takeScreenshotForExtendReport("userCart1Test"))  );

        return PageFactory.initElements(driver, CartPage.class) ;
    }




    public WishlistPage UserWishlistTest() {

        extent = report.ExtendReportConfig.getExtentReport() ;
        test = extent.startTest("UserWishlistTest" , "Testing to see if Wishlist button works properly")
                .assignCategory("Regression Testing").assignAuthor("Fatin Pushan").assignCategory("HomePageTEST")  ;

        test.log(LogStatus.INFO, "StartUp", "Starting up userWishListTest" )   ;
        log.info("Starting up userWishListTest");

        test.log(LogStatus.INFO,"Step 1" ,  "Clik on user wish list button" )   ;
        log.info("Clik on user wish list button");
        userWishlist.click();

        test.log(LogStatus.INFO, "Step 2" ,"Checking to see if the actual value of wish list page title is equal to the expected \"Wishlist\"" )   ;
        log.info("Checking to see if the actual value of wish list page title is equal to the expected \"Wishlist\"");

        try {

            Assert.assertEquals(getTitle.getText(), "Wishlist");
        } catch (AssertionError e) {
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "Test has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(takeScreenshotForExtendReport("UserWishlistTest")));
            throw new RuntimeException("Test Has Failed during assertion") ;
        }

        test.log(LogStatus.PASS, "Step 3" ,"User wish list button was clicked on successful" )   ;
        log.info("User wish list button was clicked on successful ");

        test.log(LogStatus.INFO, "Screenshot" ,test.addScreenCapture(takeScreenshotForExtendReport("UserWishlistTest")) )   ;

        //for this project we will end the test of WishlistPage page here
        return PageFactory.initElements(driver, WishlistPage.class) ;
    }





    public MyAccountPage myAccount() {

        extent = report.ExtendReportConfig.getExtentReport() ;

        test = extent.startTest("Login Button Test", "We are trying to click on login").assignAuthor("Fatin Pushan")
                .assignCategory("Regression Testing") .assignCategory("HomePageTEST")   ;
        test.log(LogStatus.INFO, "Start Up",  "HomePage Start UP" );


        test.log(LogStatus.INFO,"Step 1" ,  "Navigating to Home Page of Scaled Upit");
        test.log(LogStatus.PASS, "Step 2" ,  "Clicked on the \\\"Login\\\" button ");
        log.info("MyAccount Test");
        log.info("Click on MyAccount");

        myAccount.click();

        try {

            Assert.assertEquals(getMyAccountText.getText(), "My account");
        } catch (AssertionError e) {
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "Test has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(takeScreenshotForExtendReport("myAccount")));
            throw new RuntimeException("Test Has Failed during assertion") ;
        }


        log.info("Clicked on \"MY ACCOUNT\" successful ");
        test.log(LogStatus.INFO, "SCREEN", test.addScreenCapture(takeScreenshotForExtendReport("myAccount")));

        return PageFactory.initElements(driver, MyAccountPage.class) ;
    }


















}
