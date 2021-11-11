package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions
	(
		features = "src/test/resources/Features",
		glue = "StepsDefinition",
		tags = "@HaltAmazon1"
	)
public class TestRunner {
	
	public static void main(String[] args) throws Throwable {
		cucumber.api.cli.Main.main(args );
	}
}
