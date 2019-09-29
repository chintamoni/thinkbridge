package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Workflows;

public class MasGlobalSteps{
	
	@Given("^user has initialised browser$")
	public void user_has_initialised_browser(){
		//Do Nothing as browser is already installed by DefinitionPage constructor
	}

	@Given("^I am on the \"([^\"]*)\"$")
	public void i_am_on_the(String arg1){
	    // Write code here that turns the phrase above into concrete actions
		Workflows.openBrowser(arg1);
	}

	@When("^I entered searchtext \"([^\"]*)\" into the search field$")
	public void i_entered_searchtext_into_the_search_field(String arg1){
	    // Write code here that turns the phrase above into concrete actions
		Workflows.specifySearchText(arg1);
	}

	@When("^I click the Google Serch button$")
	public void i_click_the_Google_Serch_button(){
	    // Write code here that turns the phrase above into concrete actions
		Workflows.performSearch();
	}

	@Then("^I go to the search result page$")
	public void i_go_to_the_search_result_page(){
		//Do Nothing as we are not giving sometime to load the page completely
		Workflows.waitBrowser(20);
	}

	@Then("^the first result is The Name of the Wind - Patrick Rothfuss$")
	public void the_first_result_is_The_Name_of_the_Wind_Patrick_Rothfuss(){
		//Do Nothing as we are clicking on the matching first record only and is covered in next step
	}

	@When("^I click on the first result link$")
	public void i_click_on_the_first_result_link(){
		Workflows.openFirstWebSearchResult();
		Workflows.waitBrowser(40);
	}

	@Then("^I go to the Patrick Rothfuss - The Books page$")
	public void i_go_to_the_Patrick_Rothfuss_The_Books_page(){
		Workflows.assertBookPage();
	}

	@When("^I entered autosuggestedtext \"([^\"]*)\" into the search field$")
	public void i_entered_autosuggestedtext_into_the_search_field(String arg1){
	    // Write code here that turns the phrase above into concrete actions
		Workflows.specifyAutoSearchText(arg1);
	}

	@When("^the suggesstion list is displayed$")
	public void the_suggesstion_list_is_displayed(){
		Workflows.validateAutoSuggstOptions();
	}

	@When("^I click on the first suggesstion in the list$")
	public void i_click_on_the_first_suggesstion_in_the_list(){
		Workflows.clickFirstAutoSuggstOption();
	}

	@After
	@Then("^closing browser after scenario execution$")
	public void closing_browser_after_scenario_execution(){
		Workflows.stopExecution();
	}
}
