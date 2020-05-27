Feature:Submit data to webdriver University.com using contact us form
  A user should be able to submit information via contact us form
  If a user clicks on reset button all information will be lost.
  Background:
    Given I access Webdriver University
    When I click on contact-us link

  Scenario:Submit information using the contact-us form

    And I enter a valid firstname
    And I enter a valid lastname
    |Batson|Jackson|Rooks
    And I enter a valid email adddress
    And I enter comments
    And I click on submit button
    Then Information should be submitted sucessfully.




