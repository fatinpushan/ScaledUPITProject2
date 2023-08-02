package basemethod;

import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;


public class BaseMethod {

    private WebDriver driver = null ;
    private ExtentReports extent = null ;
    private ExtentTest test = null ;

  private static Logger log = LogManager.getLogger(BaseMethod.class.getName()) ;



    @BeforeMethod
    @Parameter (names = {"driverName"})
    public void beforeMethod(@Optional ("chrome") String driverName){
        browser.BrowserClass.setDriver(driverName);
        driver = browser.BrowserClass.getDriver() ;
        driver.navigate().to(utility.GetPropertiesClass.getProperties("URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
        driver.manage().window().maximize();

        extent = report.ExtendReportConfig.getExtentReport() ;


        log.info("******************************");
        log.info("***********STARTING***********");
        log.info("******************************");



    }


    @AfterMethod
    public void afterMethod(){

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            log.error("Thread Sleep Runtime Exception");
            throw  new RuntimeException() ;
        }

       report.ExtendReportConfig.endTest();
        report.ExtendReportConfig.flush();

        driver.close();
        driver.quit();
    }




    public HomePage startTestMethod(){
        return PageFactory.initElements(driver, HomePage.class) ;
    }



    public static void takeScreenshot(String name){

        File file = ((TakesScreenshot)browser.BrowserClass.getDriver()).getScreenshotAs(OutputType.FILE) ;

        try {
            FileUtils.copyFile(file, new File("screenshot/" + name + ".png"));
        } catch (IOException e) {
            log.error("IOException Error");
            e.printStackTrace();
        }

    }


    public String  takeScreenshotForExtendReport(String name){
        File file = ((TakesScreenshot)browser.BrowserClass.getDriver()).getScreenshotAs(OutputType.FILE) ;
        String filePath = "extend-report/report" + name + ".png" ;
        try {
            FileUtils.copyFile(file, new File(filePath));
        } catch (IOException e) {
            log.error("IOException Error");
            e.printStackTrace();
        }
        return filePath ;

    }

    public void selectByVisibleText(String textName, WebElement elementName) {

        Select select = new Select(elementName) ;

        select.selectByVisibleText(textName);

    }


    public void selectByIndex(int index, WebElement elementName) {

        Select select = new Select(elementName) ;

        select.selectByIndex(index);

    }

    public void selectByValue(String value, WebElement elementName) {

        Select select = new Select(elementName) ;

        select.selectByValue(value);

    }



    public void hoverOverElement(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver) ;
        actions.moveToElement(element).perform();

    }


    public void hoverOverElementAndClick(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver) ;
        actions.moveToElement(element).click().build().perform();

    }



    private String  getCurrentWindowHandle ;

    public void switchToNewWindow(WebDriver giveDriverName){

        getCurrentWindowHandle = giveDriverName.getWindowHandle() ;
        Set<String> allWindowHandles = new LinkedHashSet<>() ;


        for(String x : giveDriverName.getWindowHandles()) {
            allWindowHandles.add(x) ;
        }


        for(String y : allWindowHandles)
        {
            if (!y.equals(getCurrentWindowHandle)  ) {
                giveDriverName.switchTo().window(y) ;
            }
        }

    }

    public String switchToCurrentWindow(){

        return getCurrentWindowHandle;


    }



    public void openLinkInNewWindow(WebElement elementName) {

        String openInNewTab = Keys.chord(Keys.SHIFT, Keys.ALT, Keys.RETURN) ;

        elementName.sendKeys(openInNewTab);

    }


    public void scrollToElement(WebElement element){
        Actions actions = new Actions(driver) ;
        actions.moveToElement(element).perform();

    }


    public void scrollByAmount(int x, int y){
        Actions actions = new Actions(driver) ;
        actions.scrollByAmount(x,y).perform(); ;

    }

    public void threadSleepWait(int numberOfSeconds){

        try {
            Thread.sleep(1000L * numberOfSeconds ) ;
        } catch (InterruptedException e) {
            System.out.println("Error during thread sleep wait method");
            throw new RuntimeException() ;
        }



    }







}
