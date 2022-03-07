package Steps2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Servicenow extends Baseclass{

	@Given("Open the Chrome")
	public void open_the_chrome() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 

	}
	@Given("Enter the URL as {string}")
	public void enter_the_url(String url) {
		driver.get(url);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	@Given("Enter the UserName in Servicenow as {string}")
	public void enter_the_user_name_in_servicenow(String username) throws InterruptedException {
		driver.switchTo().frame("gsft_main");
		WebElement Username = driver.findElement(By.name("user_name"));
		Username.sendKeys(username);
		

	}
	@Given("Enter the Password in Servicenow as {string}")
	public void enter_the_password_in_servicenow(String password) throws InterruptedException {
		driver.findElement(By.name("user_password")).sendKeys(password);
	//	Thread.sleep(3000);
	}
	@When("Click on the Login bttn")
	public void click_on_the_login_bttn() throws InterruptedException {
		driver.findElement(By.name("not_important")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	@Given("Click on the All button as {string}")
	public void click_on_the_all_button(String Filter) throws InterruptedException {
		WebElement search = driver.findElement(By.xpath("//input[@id='filter']"));
		search.sendKeys(Filter);
		search.click();
		driver.findElement(By.linkText("All")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	@When("Click on the New button")
	public void click_on_the_new_button() throws InterruptedException {
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text()='New']")).click();
	

	}
	@Given("Enter a value for Caller as {string}")
	public void enter_a_value_for_caller(String Caller_name) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys(Caller_name);
		Thread.sleep(3000);
	}
	@Given("Enter value for short_description as {string}")
	public void enter_value_for_short_descriptionn(String short_description) throws InterruptedException {
		driver.findElement(By.id("incident.short_description")).sendKeys(short_description);
		
	}
	@Then("Read the incident number and save it a variable")
	public void read_the_incident_number_and_save_it_a_variable() throws InterruptedException {
		Object elementval = driver.findElement(By.xpath("(//span[text()='Number']/following::input)[2]")).getAttribute("value");
		System.out.println(elementval);
	

	}
	@When("Click on Submit button")
	public void click_on_submit_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		System.out.println("Incident is Created");

	}

}
