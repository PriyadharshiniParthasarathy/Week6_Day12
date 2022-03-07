package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

		features ="src/test/java/features1",
		glue ="Steps2",
		monochrome =true,
		publish =true,
		tags = "@smoke or @sanity"
	
		)

public class Runner1 extends AbstractTestNGCucumberTests {

}
