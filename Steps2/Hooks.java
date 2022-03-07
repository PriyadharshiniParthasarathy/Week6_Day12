package Steps2;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Baseclass {
	@Before
	public void precondition() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.manage().window().maximize();
   
	}
	
	@After
	public void postcondition() {
		driver.close();
	}

}
