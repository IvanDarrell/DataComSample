package ElementPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import Actions.BrowserHelper;
import ExtentLogger.Report;
import SeleniumActions.ElementActions;

public class ElementPage extends Report{
	
	
	
	 WebElement element = null;
	

	@FindBy(xpath="//input[@id\"search\"]")
	public WebElement textfieldmode;
	
	

	
	
	public WebElement textfield (WebDriver driver,String input) {
		
		if (driver.findElements(By.xpath("//input[@id='"+input+"']")).size()!=0) {
			
			element = driver.findElement(By.xpath("//input[@id='"+input+"']"));
			
		} else if (driver.findElements(By.xpath("//input[@type='"+input+"']")).size()!=0){
			
			element = driver.findElement(By.xpath("//input[@type='"+input+"']"));
			
			
		}else  {
				
			
			System.out.println("Element is not visible");
			
			
		}
		
		
		
		
		
		
		return element;
		
		
		
	}
	
	
	public WebElement youtubevideo (WebDriver driver,String title) {
		
		if (driver.findElements(By.xpath("//*[contains(text(),'"+title+"')]/parent::a/parent::h3/parent::div/parent::div/parent::div/preceding-sibling::ytd-thumbnail/a[@id=\"thumbnail\"]")).size()!=0) {
			
			element = driver.findElement(By.xpath("//*[contains(text(),'"+title+"')]/parent::a/parent::h3/parent::div/parent::div/parent::div/preceding-sibling::ytd-thumbnail/a[@id=\"thumbnail\"]"));
			
			
		} else {
			
			System.out.println("Element is not visible");
			
		}
		
		
		return element;
		
	}
	
	
	public WebElement youtubeplayer (WebDriver driver,String title) {
		
		
		if (driver.findElements(By.className(title)).size()!=0) {
			
			element = driver.findElement(By.className(title));
			
			System.out.println("Element is visible");
			
		} else {
			
			System.out.println("Element is not visible");
			
		}
		
		
		
		return element;
		
		
	}
	
	public WebElement button (WebDriver driver, String title) {
		
		
		if(driver.findElements(By.xpath("(//span[contains(text(),'"+title+"')])[1]")).size()!=0) {
			
			element = driver.findElement(By.xpath("(//span[contains(text(),'"+title+"')])[1]"));
			
		} else if (driver.findElements(By.xpath("//button//span[contains(text(),'"+title+"')]")).size()!=0) {
			
			element = driver.findElement(By.xpath("//button//span[contains(text(),'"+title+"')]"));
			
			
			
		} else
		
		
		
		
		
		{
			
			
			System.out.println("Element is not visible");
			
		}
		
		
		
		
		
		
		
		return element;
		
	}
	
	
	public WebElement link (WebDriver driver, String title) {
		
		
		
		
		if (driver.findElements(By.xpath("(//a[contains(@title, '"+ title +"') and text() = '"+ title +"'])[1]")).size()!=0) {
			
			element = driver.findElement(By.xpath("(//a[contains(@title, '"+ title +"') and text() = '"+ title +"'])[1]"));
			
			
		}
		
		return element;
		
		
		
		
		
		
		
		
	}
	
	
	
}
