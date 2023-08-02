package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class GetPropertiesClass {

    private static Logger log = LogManager.getLogger(GetPropertiesClass.class.getName()) ;


    public static String getProperties(String propertiesKey){
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/info.properties") ;

            Properties properties = new Properties() ;
            properties.load(fileInputStream);
        return     properties.getProperty(propertiesKey) ;

        } catch (IOException e) {
            log.error("IOException Error");
            e.printStackTrace();
        }
        return null ;
    }






}
