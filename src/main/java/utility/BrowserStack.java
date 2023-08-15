package utility;

import basemethod.BaseMethod;
import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserStack extends BaseMethod {


    public static final String username = utility.GetPropertiesClass.getProperties("browserStackUsername") ;
    public static final String key = utility.GetPropertiesClass.getProperties("accessKey") ;

    public static final String url = "https://" + username + ":" + key + "@hub-cloud.browserstack.com/wd/hub";



    public static  WebDriver getCloudDriver() throws MalformedURLException  {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", utility.GetPropertiesClass.getProperties("browserStack.platformName"));
        cap.setCapability("browserVersion", utility.GetPropertiesClass.getProperties("browserStack.browserVersion"));

        //extra
      //  cap.setCapability("setWindowRect", utility.GetPropertiesClass.getProperties("browserStack.setWindowRect"));

            return driver = new RemoteWebDriver(new URL(url), cap ) ;

    }








}
