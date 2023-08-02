package report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;

public class ExtendReportConfig {

  static   ExtentReports extent ;
  static   ExtentTest test ;


    public static synchronized ExtentReports getExtentReport(){
        if(extent == null) {


            extent = new ExtentReports("extend-report/report/extent.html", true) ;

            extent.addSystemInfo("Host Name", "localhost")
                    .addSystemInfo("Environment", "Chrome 114.0")
                    .addSystemInfo("User Name", "Fatin Pushan") ;
            extent.loadConfig(new File("src/main/resources/extent-report-config.xml"));
        }


        return extent ;
    }


    public static void starTest(String testName, String testDescription){
        test = extent.startTest(testName,testDescription ) ;
    }

    public static void logStep(LogStatus status, String stepName, String stepDescription){

        test.log(status, stepName, stepDescription);
    }

    public static void endTest(){
        extent.endTest(test);
    }

    public static  void flush(){
        extent.flush();
    }

    public static  void close(){
        extent.close();
    }






}
