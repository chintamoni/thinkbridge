Feature: Google Homepage Search

  @Background
  Scenario: Starting new browser instance
    Given user has initialised browser

  @tag1
  Scenario Outline: User can search with Google Search
    Given I am on the "<homepageurl>"
    When I entered searchtext "<searchText>" into the search field
    And I click the Google Serch button
    Then I go to the search result page
    And the first result is The Name of the Wind - Patrick Rothfuss
    When I click on the first result link
    Then I go to the Patrick Rothfuss - The Books page
    Examples:
    |searchText|homepageurl|
    |The name of the wind|https://www.google.com|
    
  @tag2
  Scenario Outline: User can search using the suggesstions
    Given I am on the "<homepageurl>"
    When I entered autosuggestedtext "<suggesstedsearchText>" into the search field
    And the suggesstion list is displayed
    And I click on the first suggesstion in the list
    Then I go to the search result page
    And the first result is The Name of the Wind - Patrick Rothfuss
    When I click on the first result link
    Then I go to the Patrick Rothfuss - The Books page 
    Examples:
    |suggesstedsearchText|homepageurl|
    |The name of the w|https://www.google.com|
    

  @After
  Scenario: closing browser session
    Then closing browser after scenario execution
