Feature: Test login functionalies
@Positive_test
  Scenario: Check login is successful with valid credentials
    Given a user is on the login page
    When user enter email "rayanmondo@gmail.com" and click on continue button and enter password "Taskani12"
    And user click on Sign-in button
    Then user is navigated to home page
@negative_test
Scenario: Check login with invalid  credentials
  Given a user is on the login page
  When user enter email "rayanmondo@gmail.com" and click on continue button and enter password "taaskani12"
  And user click on Sign-in button
  Then user is unable navigated to home page


  @dataDriven_test
  Scenario Outline: check login is successful with multiple credentials
    Given a user is on the login page
    When user enter email "<emailaddres>" and click on continue button and enter password "<password>"
    And user click on Sign-in button
    Then user is navigated to home page


  Examples:
    |emailaddres|password|
    |rayanmondo@gmail.com|Taskani12|


