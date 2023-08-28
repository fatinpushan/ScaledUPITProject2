package browser;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessBrowserClass {



    public static ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions() ;
   return chromeOptions.addArguments("--headless=new") ;
    }
    public static FirefoxOptions getfirefoxOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions() ;

       return firefoxOptions.addArguments("--headless=new") ;
    }

    public static EdgeOptions getedgeOptions(){
        EdgeOptions edgeOptions = new EdgeOptions() ;
       return edgeOptions.addArguments("--headless=new") ;
    }

}
