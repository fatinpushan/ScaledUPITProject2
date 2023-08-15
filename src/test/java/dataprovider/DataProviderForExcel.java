package dataprovider;

import org.testng.annotations.DataProvider;
import utility.ReadXlsxFileClass;

import java.util.Objects;

public class DataProviderForExcel {



    @DataProvider (name = "provider2")
    public Object[][] excel(){

        utility.ReadXlsxFileClass.setXLSXFileInfo();

        Object[][] objects = new Object[utility.ReadXlsxFileClass.getListSize()][2] ;

       for(int i = 0 ; i < utility.ReadXlsxFileClass.getListSize() ; i++){
           objects[i][0] = ReadXlsxFileClass.userEmail.get(i) ;
       }
        for(int i = 0 ; i < utility.ReadXlsxFileClass.getListSize() ; i++){
            objects[i][1] = ReadXlsxFileClass.userPassword.get(i) ;
        }
        return objects ;
    }
}
