package pages;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Workflow;

public class Facebook{
	
	@BeforeTest
	public void beforeTest() {
		new Workflow();
	}

	@Test
	public void facebookLogin() {
		Workflow.loginToFacebook();
	}

	@Test(dependsOnMethods={"facebookLogin"})
	public void addNewPost() {
	    Workflow.postStatusMessage();	
	}
	
	@Test(dependsOnMethods={"facebookLogin", "facebookLogin"})
	public void verifyMessage() {
	    Workflow.validateStatusMessage();	
	}
	
	@AfterTest
	public void afterTest() {
		Workflow.afterTest();
	}
}
