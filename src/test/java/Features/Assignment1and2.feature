
Feature:Enter Flight details,verify the search results and validate the login credentials
  When i enter a source and destination on Cleartrip booking website
  and click on search,i should get valid results and a correct title.
  I should also be able to validate the error message when i enter invalid login credentials
  Background:
    Given I access Cleartrip website
    And Verify the title


  @cleartrip
  Scenario: Validate the search results and title for a Cleartrip booking website
    When I select "BLR" as FROM
    And I select "PNQ" as TO
    And I select a date
    And I click on Search button
    Then NonZero search results should populate

  @cleartrip
    Scenario: Validate the login for cleartrip website
      I should get an error message when i enter wrong credentials during login in
      Cleartrip website
      When I click on login button
      And give username as "Manu123@gmail.com"
      And give password as "India1234"
      And click on login button
      Then I should get a valid error message
