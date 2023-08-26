package pages;

import basemethod.BaseMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.FakerClass;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddressesPage extends BaseMethod {

    WebDriver driver = browser.BrowserClass.getDriver() ;
  //  List<WebElement> shippingInfo = driver.findElements(By.xpath("//*[@class='woocommerce-input-wrapper']/input")) ;


    List<WebElement> shippingInfo = driver.findElements(By.xpath("//*[@id=\"shipping_first_name\"]")) ;



    List<WebElement> addShippingButton = driver.findElements(By.linkText("Add")) ;

    @FindBy(xpath = "//*[@class='woocommerce-input-wrapper']/input") private WebElement element ;

public void changeShippingAddress(){
    FakerClass fakerClass = new FakerClass() ;

    addShippingButton.get(1).click();

//    System.out.println( shippingInfo.size());

    threadSleepWait(4000);

    shippingInfo.get(0).sendKeys(fakerClass.getFirstName());
    shippingInfo.get(1).sendKeys(fakerClass.getLastName());
    shippingInfo.get(2).sendKeys("FATIN.INC");
    shippingInfo.get(3).sendKeys(fakerClass.getAddress());
    shippingInfo.get(4).sendKeys("APT 1D");
    shippingInfo.get(5).sendKeys(fakerClass.getCity());
    shippingInfo.get(6).sendKeys(fakerClass.getZipCode());

    selectByValue("United States (US)" , shippingInfo.get(3));







}




}
