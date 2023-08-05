package pages;

import basemethod.BaseMethod;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyAccountPage extends BaseMethod {


    private WebDriver driver = browser.BrowserClass.getDriver() ;
    Logger log = LogManager.getLogger(MyAccountPage.class.getName());

    @FindBy(id= "username") private WebElement usernameOrEmailAddressField ;
    @FindBy(id= "password") private WebElement passwordField ;
    @FindBy(css= "[name='login']") private WebElement loginButton ;
    @FindBy(id= "rememberme") private WebElement remembermeCheckBox ;

    @FindBy(xpath = "//*[@class='woocommerce']/nav/ul/li/a") private WebElement dashboardTextAfterLogin ;
    @FindBy(xpath = "//*[@class='woocommerce-error']/li") private WebElement loginErrorMessage  ;
    @FindBy (linkText = "Orders") private WebElement ordersPageButton ;
    @FindBy (css = "[class='entry-title']") private  WebElement getPageTitle ;
    @FindBy (linkText = "Downloads") private WebElement downloadsPageButton ;
    @FindBy (linkText = "Addresses") private WebElement addressesPageButton ;
    @FindBy (linkText = "Account details") private WebElement accountDetailsPageButton ;
    @FindBy (linkText = "Logout") private WebElement logoutButton ;
    @FindBy (xpath = "//*[@class='u-column1 col-1']/h2") private WebElement getLoginTxt ;


    public AccountDetailsPage accountDetailsPageButtonTest(){
        extent = report.ExtendReportConfig.getExtentReport()  ;

        test = extent.startTest("accountDetailsPageButtonTest", "Testing to see if we can click on the Account page button from the account page")
                .assignCategory("Regression Testing").assignAuthor("Fatin Pushan").assignCategory("MyAccountPageTEST") ;


        test.log(LogStatus.INFO,"Start UP", "Starting accountDetailsPageButtonTest" );
        log.info("Starting accountDetailsPageButtonTest");

        log.info("Click on Account page Button");
        test.log(LogStatus.INFO,"Step 1", "Click on Account page Button" );
        accountDetailsPageButton.click();

        log.info("Seeing if the actual value is the same as the expected value \"Account details\"");
        test.log(LogStatus.INFO,"Step 2", "Seeing if the actual value is the same as the expected value \"Account details\"" );

        try {

            Assert.assertEquals(getPageTitle.getText(), "Account details");
        } catch (AssertionError e) {
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "Test has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(takeScreenshotForExtendReport("accountDetailsPageButtonTest")));
            throw new RuntimeException("Test Has Failed during assertion") ;
        }


        test.log(LogStatus.PASS,"Step 3", "accountDetailsPageButtonTest completed successful" );
        log.info("accountDetailsPageButtonTest completed successful");

        test.log(LogStatus.INFO, "Screenshot", test.addScreenCapture(takeScreenshotForExtendReport("accountDetailsPageButtonTest")));
        return PageFactory.initElements(driver, AccountDetailsPage.class) ;
    }



    public AddressesPage addressesPageButtonTest(){
        extent = report.ExtendReportConfig.getExtentReport()  ;

        test = extent.startTest("addressesPageButtonTest", "Testing to see if we can click on the Addresses page button from the account page")
                .assignCategory("Regression Testing").assignAuthor("Fatin Pushan").assignCategory("MyAccountPageTEST") ;


        test.log(LogStatus.INFO,"Start UP", "Starting addressesPageButtonTest" );
        log.info("Starting addressesPageButtonTest");

        log.info("Click on addresses page Button");
        test.log(LogStatus.INFO,"Step 1", "Click on addresses page Button" );
        addressesPageButton.click();

        log.info("Seeing if the actual value is the same as the expected value \"Addresses\"");
        test.log(LogStatus.INFO,"Step 2", "Seeing if the actual value is the same as the expected value \"Addresses\"" );

        try {

            Assert.assertEquals(getPageTitle.getText(), "Addresses");
        } catch (AssertionError e) {
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "Test has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(takeScreenshotForExtendReport("addressesPageButtonTest")));
            throw new RuntimeException("Test Has Failed during assertion") ;
        }


        test.log(LogStatus.PASS,"Step 3", "addressesPageButtonTest completed successful" );
        log.info("addressesPageButtonTest completed successful");

        test.log(LogStatus.INFO, "Screenshot", test.addScreenCapture(takeScreenshotForExtendReport("addressesPageButtonTest")));
        return PageFactory.initElements(driver, AddressesPage.class) ;
    }







    public DownloadsPage downloadsPageButtonTest(){
        extent = report.ExtendReportConfig.getExtentReport()  ;

        test = extent.startTest("downloadsPageButtonTest", "Testing to see if we can click on the downloads page button from the account page")
                .assignCategory("Regression Testing").assignAuthor("Fatin Pushan").assignCategory("MyAccountPageTEST") ;


        test.log(LogStatus.INFO,"Start UP", "Starting downloadsPageButtonTest" );
        log.info("Starting downloadsPageButtonTest");

        log.info("Click on downloads page Button");
        test.log(LogStatus.INFO,"Step 1", "Click on downloads page Button" );
        downloadsPageButton.click();

        log.info("Seeing if the actual value is the same as the expected value \"Downloads\"");
        test.log(LogStatus.INFO,"Step 2", "Seeing if the actual value is the same as the expected value \"Downloads\"" );

        try {

            Assert.assertEquals(getPageTitle.getText(), "Downloads");
        } catch (AssertionError e) {
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "Test has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(takeScreenshotForExtendReport("downloadsPageButtonTest")));
            throw new RuntimeException("Test Has Failed during assertion") ;
        }


        test.log(LogStatus.PASS,"Step 3", "downloadsPageButtonTest completed successful" );
        log.info("downloadsPageButtonTest completed successful");

        test.log(LogStatus.INFO, "Screenshot", test.addScreenCapture(takeScreenshotForExtendReport("downloadsPageButtonTest")));
        return PageFactory.initElements(driver, DownloadsPage.class) ;
    }

    public OrdersPage orderPageButtonTest(){

        extent = report.ExtendReportConfig.getExtentReport()  ;

        test = extent.startTest("orderPageButtonTest", "Testing to see if we can click on the order page button from the account page")
                .assignCategory("Regression Testing").assignAuthor("Fatin Pushan") .assignCategory("MyAccountPageTEST") ;

        test.log(LogStatus.INFO,"Start UP", "Starting orderPageButtonTest" );
        log.info("Starting orderPageButtonTest");

        test.log(LogStatus.INFO,"Step 1", "Click on order page Button" );
        log.info("Click on order page Button ");
        ordersPageButton.click();

        test.log(LogStatus.INFO,"Step 2", "Seeing if the actual value is the same as the expected value \"Orders\"" );
        log.info("Seeing if the actual value is the same as the expected value \"Orders\"");

        try {

            Assert.assertEquals(getPageTitle.getText() , "Orders");
        } catch (AssertionError e) {
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "Test has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(takeScreenshotForExtendReport("orderPageButtonTest")));
            throw new RuntimeException("Test Has Failed during assertion") ;
        }


        test.log(LogStatus.PASS,"Step 3", "orderPageButtonTest completed successful" );
        log.info("orderPageButtonTest completed successful");

        test.log(LogStatus.INFO, "Screenshot", test.addScreenCapture(takeScreenshotForExtendReport("orderPageButtonTest")));

        return PageFactory.initElements(driver, OrdersPage.class) ;
    }




    public MyAccountPage logOutFromAccountPage() {

        extent= report.ExtendReportConfig.getExtentReport() ;
        test = extent.startTest("logOutFromAccountPage", "Testing to see if user can log out from the \"MY ACCOUNT\" page ").assignAuthor("Fatin Pushan")
                .assignCategory("Regression Testing") .assignCategory("MyAccountPageTEST") ;

        test.log(LogStatus.INFO , "Start Up", "Starting logOutFromAccountPage test");


        test.log(LogStatus.INFO , "Step 1", "Starting logOutFromAccountPage Test");
        log.info("Starting logOutFromAccountPage Test");

        test.log(LogStatus.INFO , "Step 2", "Clicking on log out button from the account page");
        log.info("Clicking on log out button from the account page");
        logoutButton.click();

        test.log(LogStatus.INFO , "Step 3", "Comparing the actual value from the expected value \"Login\"");
        log.info("Comparing the actual value from the expected value \"Login\"");


        try {

            Assert.assertEquals(getLoginTxt.getText(), "Login");
        } catch (AssertionError e) {
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "Test has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(takeScreenshotForExtendReport("logOutFromAccountPage")));
            throw new RuntimeException("Test Has Failed during assertion") ;
        }



        test.log(LogStatus.PASS , "Step 4", "logOutFromAccountPage was completed successful");
        log.info("logOutFromAccountPage was completed successful");


        test.log(LogStatus.INFO, "Screenshot" , test.addScreenCapture(takeScreenshotForExtendReport("logOutFromAccountPage")));

        return PageFactory.initElements(driver, MyAccountPage.class) ;
    }





    public MyAccountPage loginUserWithPropertiesInformation(){

        extent = report.ExtendReportConfig.getExtentReport() ;
        test = extent.startTest("Login Page Test With Properties Information", "Login with data from the \"info.properties\" file"  )
                .assignAuthor("Fatin Pushan").assignCategory("Regression Testing").assignCategory("MyAccountPageTEST")    ;

        test.log(LogStatus.INFO, "Setup", "HomePageTest has been completed, SetUp has been completed"   );
        test.log(LogStatus.INFO, "Step 1", "Entered Email in the \"username and email\" Field"  );
        test.log(LogStatus.INFO, "Step 2", "Entered password in the \"password\" Field"  );
        test.log(LogStatus.INFO, "Step 3", "Click on the \"Remember me\" Checkbox"  );
        test.log(LogStatus.PASS, "Step 4" , "Click on the \"Login\" button, test completed"   );


        log.info("Starting LoginUserWith");

        log.info("Sending email to the email field \"fatinpushan3@gmail.com\"");
        usernameOrEmailAddressField.sendKeys(utility.GetPropertiesClass.getProperties("email"));

        log.info("Sending password to password field \"223892852Pp@ \" ");
        passwordField.sendKeys(utility.GetPropertiesClass.getProperties("password")) ;

        log.info("Click on remember me checkbox");
        remembermeCheckBox.click();

        log.info("Click on loging button");
        loginButton.click();

        try {

            Assert.assertEquals(dashboardTextAfterLogin.getText(), "Dashboard");
        } catch (AssertionError e) {
            log.info("Test Has Failed during assertion");
            test.log(LogStatus.FAIL, "Failed TEST", "Test has failed please see screenshot and log to fix issue"
                    + test.addScreenCapture(takeScreenshotForExtendReport("loginUserWithPropertiesInformation")));
            throw new RuntimeException("Test Has Failed during assertion") ;
        }



        log.info(" loginUserWithPropertiesInformation passed successful ");
        test.log(LogStatus.INFO, "Screenshot", test.addScreenCapture(takeScreenshotForExtendReport("LoginPageTestWithPropertiesInformation")) );

        return PageFactory.initElements(driver, MyAccountPage.class) ;
    }





    public MyAccountPage negativeLoginUserWithDataProviderInformation(String email, String password){
        extent = report.ExtendReportConfig.getExtentReport() ;

        test =   extent.startTest("negativeLoginUserWithDataProviderInformation", "Trying to test login page with fake data , should not " +
                "be able to login").assignAuthor("Fatin Pushan").assignCategory("Regression Testing").assignCategory("MyAccountPageTEST") ;


        test.log(LogStatus.INFO, "Start Up" , "Starting LoginUserWith"   );
        log.info("Starting LoginUserWith");

        test.log(LogStatus.INFO, "Step 1" , "Sending email to the email field"   );
        log.info("Sending email to the email field");
        usernameOrEmailAddressField.sendKeys(email);

        test.log(LogStatus.INFO, "Step 2" , "Sending password to password field"   );
        log.info("Sending password to password field");
        passwordField.sendKeys(password) ;

        test.log(LogStatus.INFO, "Step 3" , "Click on remember me checkbox"   );
        log.info("Click on remember me checkbox");
        remembermeCheckBox.click();

        test.log(LogStatus.INFO, "Step 4" , "Click on loging button"   );
        log.info("Click on loging button");
        loginButton.click();


        try{
            Assert.assertEquals(loginErrorMessage.getText(), "Unknown email address. Check again or try your username.");
        } catch (AssertionError e) {

            Assert.assertEquals(loginErrorMessage.getText(), "Error: The password you entered for the email address fatinpushan3@gmail.com is incorrect. Lost your password?");
        }


        log.info(" loginUserWithPropertiesInformation passed successful ");
        test.log(LogStatus.PASS, "Step 5" , "loginUserWithPropertiesInformation passed successful "   );

        test.log(LogStatus.INFO , "Screenshot", test.addScreenCapture(takeScreenshotForExtendReport("negativeLoginUserWithDataProviderInformation")) );


        return PageFactory.initElements(driver, MyAccountPage.class) ;
    }







}
