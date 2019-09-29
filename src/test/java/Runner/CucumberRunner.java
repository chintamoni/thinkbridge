package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(
	features="src/main/java/features/masglobal.feature",
	glue={"src/test/java/steps/MasglobalSteps.java"},
	plugin={"html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
	dryRun = false,
	strict = true,
	tags={"@tag1", "@tag2"}
)

public class CucumberRunner {
	 }
