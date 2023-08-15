package listener;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerClass extends TestListenerAdapter {



    public void onTestStart(ITestResult tr)   {
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("** TEST IS STARTING " + tr.getName() + "**"    );
        System.out.println("******************");
        System.out.println("******************");
    }


    public void onTestSuccess(ITestResult tr){
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("** TEST HAS PASSED " + tr.getName() + "**"    );
        System.out.println("******************");
        System.out.println("******************");
    }



    public void onTestFailure(ITestResult tr){
        basemethod.BaseMethod.takeScreenshot(tr.getName());

        System.out.println("******************");
        System.out.println("******************");
        System.out.println("** TEST HAS FAILED " + tr.getName() + "**"    );
        System.out.println("******************");
        System.out.println("******************");
    }


    public void onTestSkipped(ITestResult tr){
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("** TEST HAS SKIPPED " + tr.getName() + "**"    );
        System.out.println("******************");
        System.out.println("******************");
    }



    public void onFinish(ITestContext tr){
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("** ALL TEST HAS FINISHED **"    );
        System.out.println("******************");
        System.out.println("******************");
    }




}
