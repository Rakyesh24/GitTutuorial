package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".//Features//Hook.feature",
			glue= {"stepdefs"},
			dryRun=false,
			monochrome=true,
			stepNotifications=true,
			publish=true,
			plugin= {"pretty","html:target/hooktest.html"})
							
public class HookTestRunner {

}
