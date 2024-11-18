package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ExtentLogger.Report;

public class BrowserHelper {
		
	public WebDriver driver;
	public void startbrowser (String browser, String url) {
		
		if (browser.equals("chrome")) {
			
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			
		} else if (browser.equals("edge")) {
			
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			
			
		} else  {
			
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			
			
			
		}
		
		
		
	}

}
