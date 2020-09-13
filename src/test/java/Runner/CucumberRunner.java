package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome=true,
		tags="@tag1",
		strict=false,
	features="src/main/java/features/thinkbridge.feature",
	glue={"src/test/java/steps/ThinkBridgeSteps.java"},
	plugin={"html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
	dryRun = false
	
)

public class CucumberRunner {
	 }
