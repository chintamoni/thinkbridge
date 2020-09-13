package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Workflows;

public class ThinkBridgeSteps{
	
	
	@Given("User has initialised browser")
	public void user_has_initialised_browser() {
    //Do Nothing as browser is already installed by DefinitionPage constructor
	//    throw new PendingException();
	}


	@Given("I am on the {string}")
	public void i_am_on_the(String string) {
		Workflows.openBrowser(string);
	  //  throw new PendingException();
	}

	@When("I click on languages dropdown")
	public void i_click_on_languages_dropdown() {
		Workflows.clickLanguageDropdown();
	 //   throw new PendingException();
	}
	
	@Then("I should be seeing option {string} and {string}")
	public void i_should_be_seeing_option_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	//  throw new PendingException();
	}

	@When("I select language as : {string}")
	public void i_select_language_as(String string) {
		Workflows.selectAnyLanguage(string);
	 //   throw new PendingException();
	}

	@When("I fill my name as : {string}")
	public void i_fill_my_name_as(String string) {
		Workflows.enterUsername(string);
	 //   throw new PendingException();
	}

	@When("I specify organization as : {string}")
	public void i_specify_organization_as(String string) {
		Workflows.enterOrgname(string);
	//    throw new PendingException();
	}

	@When("I specify Email as : {string}")
	public void i_specify_Email_as(String string) {
		Workflows.enterUserEmail(string);
	 //   throw new PendingException();
	}

	@When("I selected terms and condition as : {string}")
	public void i_selected_terms_and_condition_as(String string) {
		Workflows.selectTermsAndCondition(string);
	 //   throw new PendingException();
	}

	@When("I click on SignUp button")
	public void i_click_on_SignUp_button() {
       Workflows.clickSubmit();
	}
	
	@Then("I should be receiving Registration Confirmation Email")
	public void i_should_be_receiving_Registration_Confirmation_Email() {
		Workflows.verifyMail("xxxxxxxxx@gmail.com", "xxxxxxxxxx", "Please Complete JabaTalks Account");
    
	}

	@After
	@Then("closing browser after scenario execution")
	public void closing_browser_after_scenario_execution() {
		Workflows.stopExecution();
	//    throw new PendingException();
	}
}
