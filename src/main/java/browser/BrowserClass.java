package browser;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;

import java.net.MalformedURLException;

public class BrowserClass {


    private static WebDriver driver = null ;


    public static void setDriver( boolean turnOnHeadless, String driverName){

        String enterDriverName = driverName.toLowerCase() ;


        String chromeDriverPath = "/Users/fatinpushan/Documents/Fatin/Selenium/ScaledUPITProject2/drivers/chromedriver";

      //  System.setProperty("webdriver.chrome.driver", chromeDriverPath);


        switch (enterDriverName) {
            case "chrome" -> {
                if(turnOnHeadless){
                    driver = new ChromeDriver(HeadlessBrowserClass.getChromeOptions());
                } else driver = new ChromeDriver();
            }
            case "firefox" -> {
                if (turnOnHeadless){
                    driver = new FirefoxDriver(HeadlessBrowserClass.getfirefoxOptions()) ;
                } else driver = new FirefoxDriver() ;
            }
            case  "edge" ->
            {
                if (turnOnHeadless){
                    driver = new EdgeDriver(HeadlessBrowserClass.getedgeOptions()) ;
                } else  driver = new EdgeDriver()  ;
            }
            case "browserstack" ->
            {
                try {
                    driver = utility.BrowserStack.getCloudDriver();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static WebDriver getDriver(){
        return driver ;
    }



}
