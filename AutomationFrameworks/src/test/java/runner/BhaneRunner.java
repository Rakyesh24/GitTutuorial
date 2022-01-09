package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".//Features//Bhane.feature",
			glue= {"bhanedefs"},
			dryRun=false,
			monochrome=true,
			stepNotifications=true,
			publish=true,
			plugin= {"pretty","html:target/login.html"})
							
public class BhaneRunner {

}
