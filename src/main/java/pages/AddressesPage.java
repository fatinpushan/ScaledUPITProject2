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

    @FindBy(id = "shipping_first_name") private WebElement firstName ;
    @FindBy (id = "shipping_last_name") private WebElement lastName ;
    @FindBy(id = "shipping_address_1") private WebElement shippingAddress ;
    @FindBy(id = "shipping_address_2") private WebElement apartmentOptional ;
    @FindBy(id = "shipping_city") private WebElement city ;
    @FindBy(id = "shipping_postcode") private WebElement zipCode ;
    @FindBy(id = "select2-shipping_country-container") private WebElement country ;
    @FindBy(id = "select2-shipping_state-container") private WebElement state ;
    List<WebElement> addShippingButton = driver.findElements(By.linkText("Add")) ;




public void changeShippingAddress(){
    FakerClass fakerClass = new FakerClass() ;

    addShippingButton.get(1).click();
    firstName.sendKeys(fakerClass.getFirstName());
    lastName.sendKeys(fakerClass.getLastName());
    shippingAddress.sendKeys(fakerClass.getAddress());
    apartmentOptional.sendKeys(fakerClass.getZipCode());
    city.sendKeys(fakerClass.getCity());
    zipCode.sendKeys(fakerClass.getZipCode());

    selectByVisibleText("United States (US)", country);
    selectByVisibleText("New York", state);




}
}
