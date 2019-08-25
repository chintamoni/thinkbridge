package pages;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Workflow;

public class WalletHub{
	
	@BeforeTest
	public void beforeTest() {
		new Workflow();
	}

	@Test
	public void newUserCreation() {
		Workflow.createWalletHubUserAccount();
	}

	@Test(dependsOnMethods={"newUserCreation"})
	public void walletHubLogin() {
	    Workflow.loginWalletHub();	
	}
	
	@Test(dependsOnMethods={"newUserCreation", "walletHubLogin"})
	public void ratingAndReview() {
	    Workflow.walletHubScenario();	
	}
	
	@AfterTest
	public void afterTest() {
		Workflow.afterTest();
	}
}
