package Actions;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ElementPages.ElementPage;
import ExtentLogger.Report;
import SeleniumActions.ElementActions;

public class TestActions extends ElementActions {
		
	ElementPage elemp = new ElementPage();
	ElementActions actions = new ElementActions();
	Report rep = new Report();
	public String classname = this.getClass().getName();
	
	
	
	
	

	


	
	
	

	@Test
	public void initiate() {
		

		//reports.createTest("Test");
		
		//rep.testsuitereport("test");
		
		startbrowser("edge","https://datacom.com/nz/en/contact-us");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		
		String URL = driver.getCurrentUrl();
		
		wait.until(ExpectedConditions.urlMatches(URL));
		
		//test.log(Status.FAIL, "W");
		
	}
	
	@Test
	public void verifylinks () {
		
		actions.waittime(driver,10,e);
		
		actions.checkifvisible(driver, elemp.link(driver, "Solutions"), e);
		actions.waittime(driver,10,e);
		actions.checkifvisible(driver, elemp.link(driver, "Products"), e);
		actions.waittime(driver,10,e);
		actions.checkifvisible(driver, elemp.link(driver, "Industries"), e);
		actions.waittime(driver,10,e);
		actions.checkifvisible(driver, elemp.link(driver, "Discover"), e);
		actions.waittime(driver,10,e);
		actions.checkifvisible(driver, elemp.link(driver, "About US"), e);
		actions.waittime(driver,10,e);
		actions.checkifvisible(driver, elemp.link(driver, "Careers"), e);
		
		
		
	}
	
	@Test 
	public void clickalllinks () throws InterruptedException {
		
		actions.clickbyjava(driver, elemp.link(driver, "Solutions"), e);
		Thread.sleep(10000);
		actions.clickbyjava(driver, elemp.link(driver, "Products"), e);
		Thread.sleep(10000);
		actions.clickbyjava(driver, elemp.link(driver, "Industries"), e);
		Thread.sleep(10000);
		actions.clickbyjava(driver, elemp.link(driver, "Discover"), e);
		Thread.sleep(20000);
		actions.clickbyjava(driver, elemp.link(driver, "About US"), e);
		Thread.sleep(10000);
		actions.clickbyjava(driver, elemp.link(driver, "Careers"), e);
		
	}
	
	
	
	@Test 
	public void verifyloginbutton () {
		
		actions.checkifvisible(driver, elemp.button(driver, "Sign in"), e);
		
	}
	
	
	
	
	@Test
	public void login () {
		
		actions.waittime(driver,10,e);
		
		actions.clickbyjava(driver,elemp.button(driver, "Sign in"),e);
		
		actions.waittime(driver,10,e);
		
		
		actions.sendtext(elemp.textfield(driver, "email"),"t12588710@gmail.com", e);
		
		actions.clickbyjava(driver, elemp.button(driver, "Next"), e);
		
		actions.waittime(driver,10,e);
		
	}

	
	@AfterMethod
	public void initiatereport () {
		
		reports.flush();
		//driver.quit();
		
	}
	
	
	

	

}
