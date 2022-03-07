package Crossbroswer;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public RemoteWebDriver driver;
	
	@Parameters("Browser")
	@BeforeMethod
	
	public void precondition(String Browser) {
		if(Browser.equalsIgnoreCase("Chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else
			if(Browser.equalsIgnoreCase("Firefox"))
			{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			}
			else
				if(Browser.equalsIgnoreCase("Edge"))
				{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				}
        driver.manage().window().maximize();
       
 
	}
	
	@AfterMethod
	public void postcondition() {
		driver.quit();
	}

}
