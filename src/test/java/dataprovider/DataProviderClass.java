package dataprovider;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class DataProviderClass {


    @DataProvider (name = "provider1")
    public Object[][] dataProvider(){

        Faker faker = new Faker() ;

        Object[][] fakeLogin = new Object[3][2] ;

        fakeLogin[0][0] = faker.internet().emailAddress() ;
        fakeLogin[0][1] =utility.GetPropertiesClass.getProperties("password") ;

        fakeLogin[1][0] = utility.GetPropertiesClass.getProperties("email") ;
        fakeLogin[1][1] = faker.internet().password() ;

        fakeLogin[2][0] = faker.internet().emailAddress() ;
        fakeLogin[2][1] = faker.internet().password() ;

        return  fakeLogin ;

    }


}
