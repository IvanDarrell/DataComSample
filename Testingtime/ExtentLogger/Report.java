package ExtentLogger;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Actions.BrowserHelper;
import Actions.TestActions;
import SeleniumActions.ElementActions;
import freemarker.log.Logger;

public class Report extends BrowserHelper {
	
	public ExtentTest e;
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	
	/*
	public void test () {
		
		
		
				
	        // create ExtentReports and attach reporter(s)
		report = new ExtentReports();
		spark = new ExtentSparkReporter("C:\\Users\\IVAN DARRELL\\Downloads\\YESST" + ".html");
		report.attachReporter(spark);
		
		
		
		
	}
	
	
	
	public void testsuitereport (Extent test,String name) {
		reports = report.createTest("Test.html");
		report.createTest(name);
	}
	
	*/

	@BeforeTest
	public void reporter () {
		
		reports = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\" + "ExtentReportResults.html");
		reports.attachReporter(spark);
		
		
		spark.config().setTheme(Theme.DARK);
	}
	
	
	
	@BeforeMethod
	public void createtest (ITestResult result) {
		 
		String methodName = result.getMethod().getMethodName();
		e = reports.createTest(methodName);
		
		
	}
	
	/*
	@AfterMethod
	public void createtestlog () {
		
		e.log(Status.PASS,"Good");

		
	}
	*/
	
	
	/*
	public void testreport () {
		
		
		ExtentTest test = reports.createTest("MyFirstTest");
		ExtentTest node = test.createNode("");
		node.p
	}
	*/
}
