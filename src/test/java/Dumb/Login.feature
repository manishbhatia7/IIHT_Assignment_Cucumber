Feature:Login to account at webdriveruniversity.com portal using login portal

  Background:
    Given I access Webdriver University
    When i click on login portal button
    And i enter the username

    Scenario: Valid Password
      And I click on "valid" password
      And I click on login button
      Then i should be presented with sucessful validation alert

  Scenario: InValid Password
    And I click on "invalid" password
    And I click on login button
    Then i should be presented with unsucessful validation alert

