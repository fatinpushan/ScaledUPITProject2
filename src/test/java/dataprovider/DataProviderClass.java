package dataprovider;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import utility.FakerClass;

public class DataProviderClass {


    @DataProvider (name = "provider1")
    public Object[][] dataProvider(){

        FakerClass fakerClass = new FakerClass() ;

        Object[][] fakeLogin = new Object[3][2] ;

        fakeLogin[0][0] = fakerClass.getEmail() ;
        fakeLogin[0][1] =utility.GetPropertiesClass.getProperties("password") ;

        fakeLogin[1][0] = utility.GetPropertiesClass.getProperties("email") ;
        fakeLogin[1][1] = fakerClass.getPassword() ;

        fakeLogin[2][0] = fakerClass.getEmail() ;
        fakeLogin[2][1] = fakerClass.getPassword() ;

        return  fakeLogin ;

    }


}
