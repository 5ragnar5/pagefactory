package ee.rz.testsamples.tests.testng;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomTestListener extends TestListenerAdapter	{
	
 	public static String trimParameters(ITestResult tr)	{
 		return Arrays.toString(tr.getParameters()).replace("[", "(").replace("]", ")" );
 	}
 	
 	public static String convertStackTrace(Throwable trace){
 		StringWriter sw = new StringWriter();
 		PrintWriter pw = new PrintWriter(sw);
 		trace.printStackTrace(pw);     
 		return sw.toString();      
 	}
	
	@Override
	public void onTestStart(ITestResult tr)	{
		System.out.println("STARTING TEST --- " + tr.getName() + trimParameters(tr));
	}
	
	@Override
	public void onTestSuccess(ITestResult tr)	{
		System.out.println("TEST PASS --- " + tr.getName() + trimParameters(tr) + "\n");
	}

	@Override
	public void onTestSkipped(ITestResult tr)	{
		System.out.println("TEST SKIP --- " + tr.getName() + trimParameters(tr) + "\n");
	}
	
	@Override
	public void onTestFailure(ITestResult tr)	{
		System.out.println("TEST FAIL --- " + tr.getName() + trimParameters(tr) + "\n" + convertStackTrace(tr.getThrowable()));
	}
}
