package browser;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;

public class BrowserClass {


    private static WebDriver driver = null ;


    public static void setDriver(String driverName){

        String enterDriverName = driverName.toLowerCase() ;


        String chromeDriverPath = "/Users/fatinpushan/Documents/Fatin/Selenium/ScaledUPITProject2/drivers/chromedriver";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);


        switch (enterDriverName) {
            case "chrome" ->
                driver = new ChromeDriver( );
            case "firefox" ->
                driver = new FirefoxDriver() ;
            case  "edge" ->
                driver = new EdgeDriver() ;
        }
    }


    public static WebDriver getDriver(){
        return driver ;
    }



}
