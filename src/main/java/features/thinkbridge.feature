Feature: User Registration

  @tag1
  Scenario Outline: Registration Form (Happy Path)
    Given User has initialised browser
    Given I am on the "<url>"
    When I click on languages dropdown
     Then I should be seeing option "<language1>" and "<language2>"
    When I select language as : "<language1>"
    And I fill my name as : "<name>"
    And I specify organization as : "<organization>"
    And I specify Email as : "<emailAddress>"
    And I selected terms and condition as : "<agreeTerms>"
    And I click on SignUp button
    Then I should be receiving Registration Confirmation Email
    Examples:
    |url|language1|language2|name|organization|emailAddress|agreeTerms|
    |http://jt-dev.azurewebsites.net/#/SignUp|English|Dutch|xxxxx xxxx|xxxxxxx|xxxxxxx@gmail.com|Yes|

  @After
  Scenario: closing browser session
    Then closing browser after scenario execution
