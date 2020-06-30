package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		System.out.println("In onStart method "+result.getName());
			}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
       // getScreenshot(methodName);
        
				
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub	
		System.out.println(result.getName()+" test case started");
		  	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase passed is :"+result.getName());
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		
	}
			
	}

