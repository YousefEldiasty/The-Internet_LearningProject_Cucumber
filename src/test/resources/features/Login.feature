Feature: user Should be able To Login To the Website
  #Test Scenario 1
  Scenario: user login with valid username and password
  #Prerequiste to perform Action
    Given  navigate to the login Page
  #Action
    When  user enter "tomsmith" and "SuperSecretPassword!"
    And   user click on Login
  #Expected Result
    Then  user cloud login successfully
    And   user go to secure page

  #Test Scenario 2
  Scenario: user login with invalid username and password
  #Prerequiste to perform Action
    Given  navigate to the login Page
  #Action
    When  user enter "tom" and "Super"
    And   user click on Login
  #Expected Result
    Then  user cloud login unSuccessfully
    And   user still in same page