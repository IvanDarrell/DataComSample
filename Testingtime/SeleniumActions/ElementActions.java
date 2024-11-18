package SeleniumActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;

import Actions.BrowserHelper;
import ElementPages.ElementPage;

public class ElementActions extends ElementPage {
		
		

		public void clickelement (WebDriver driver, WebElement element,ExtentTest e) {
			

			
			if (element.isDisplayed()) {
				element.click();
				e.log(Status.PASS, element + " clicked");
			
			
			} else {
				
				e.log(Status.FAIL, element + " is not visible and no text entered");
			}
			
			
			/*if(Element.isDisplayed()) {
				
				Element.click();
				
			
			}*/
			
		}
		
		
		public void sendtext (WebElement element, String text,ExtentTest e) {
			
			
			if (element.isDisplayed()) {
				element.click();
				element.sendKeys(text);
				e.log(Status.PASS, text + " populated");
			
			
			} else {
				
				e.log(Status.FAIL, text + " is not visible and no text entered");
			}
			
			
		
		
		
	}
		
		
		
		
		public void sendtextandenter (WebElement element, String text,ExtentTest e) {
				
				
				if (element.isDisplayed()) {
					element.click();
					element.sendKeys(text);
					element.sendKeys(Keys.ENTER);
					e.log(Status.PASS, text + " populated and entered");
				
				
				} else {
					
					e.log(Status.FAIL, text + " is not visible and no text entered");
				}
				
				
			
			
			
		}
		
		public void waittime (WebDriver driver,Integer seconds,ExtentTest e) {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
			e.log(Status.PASS, "Waited for " + seconds +" seconds");
			
			
		}
		
		
		
		public void clickbyjava(WebDriver driver,WebElement element,ExtentTest e) {
			
			
			
			if (element.isDisplayed()) {
				
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				e.log(Status.PASS, element + " is clicked by Javascript");
			
			} else {
				
				e.log(Status.FAIL, element + " is not visible and no text entered");
			}
			
			
			
			
			
			
		}
		
		
		public void pausevideo (WebDriver driver, WebElement element,ExtentTest e)  {
			
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].play();", element);
			e.log(Status.PASS, "Video is paused");
			
			
			
	
		}
		
		
		public void checkifvisible (WebDriver driver, WebElement element,ExtentTest e) {
			

			
			if (element.isDisplayed()) {
				
				e.log(Status.PASS, element + " is visible");
			
			
			} else {
				
				e.log(Status.FAIL, element + " is not visible");
			}
			
			
			/*if(Element.isDisplayed()) {
				
				Element.click();
				
			
			}*/
			
		}
}
