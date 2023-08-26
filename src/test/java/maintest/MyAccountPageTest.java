package maintest;

import basemethod.BaseMethod;
import com.beust.jcommander.Parameter;
import dataprovider.DataProviderClass;
import dataprovider.DataProviderForExcel;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyAccountPageTest extends BaseMethod {

    @Test(groups = {"Regression Testing"})
    public void LoginPageTestWithPropertiesInformation(){
        startTestMethod().myAccount().loginUserWithPropertiesInformation() ;
    }

    @Test  (dataProvider = "provider1", dataProviderClass = DataProviderClass.class , groups = {"Regression Testing"})
    public void negativeLoginUserWithDataProviderInformation(String email, String password){
        startTestMethod().myAccount().negativeLoginUserWithDataProviderInformation(email, password) ;
    }
    @Test (groups = {"Regression Testing"})
    public void logOutFromAccountPage(){

        startTestMethod().myAccount().loginUserWithPropertiesInformation().logOutFromAccountPage() ;

    }

    @Test (groups = {"Regression Testing"})
    public void orderPageButtonTest(){
        startTestMethod().myAccount().loginUserWithPropertiesInformation().orderPageButtonTest() ;
    }



    @Test (groups = {"Regression Testing"})
    public void downloadsPageButtonTest(){
        startTestMethod().myAccount().loginUserWithPropertiesInformation().downloadsPageButtonTest() ;
    }

    @Test (groups = {"Regression Testing"})
    public void   accountDetailsPageButtonTest(){
        startTestMethod().myAccount().loginUserWithPropertiesInformation().accountDetailsPageButtonTest() ;
    }


    @Test (groups = {"Regression Testing"})
    public void   addressesPageButtonTest(){
        startTestMethod().myAccount().loginUserWithPropertiesInformation().addressesPageButtonTest() ;
    }


    @Test  (dataProvider = "provider2", dataProviderClass = DataProviderForExcel.class, groups = {"Regression Testing"} )
    public void negativeLoginUserWithXLSXFile(String email, String password){
        startTestMethod().myAccount().negativeLoginUserWithXLSXFile(email, password) ;
    }




    @Test (  threadPoolSize = 5,  invocationCount = 5 , groups = {"Regression Testing"})
    public void registerNewAccount(){
        startTestMethod().myAccount().registerNewAccount() ;

    }



}
