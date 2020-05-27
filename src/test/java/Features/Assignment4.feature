
Feature:|Enter valid and unused email id to create account and then enter registration details for that email id
  @automationpractice
   Scenario Outline:Enter valid and unused email id,enter registration details and verify registration is successful
    Given i access Automation Practice url
    When i click Registration link
    And enter the valid "<Email>" email
    And click on create account
    And select the Title
    And Type the "<First Name>"  FirstName
    And Type the "<Last Name>"   LastName
    And Assert that "<Email>" is correct
    And Type the "<passsword>"  passsword
    And Type the "<Address>" Address
    And Type the "<City>" city
    And Type the "<state>" State
    And Type the "<pincode>" Pincodde
    And Select "<Countryy>"    Counttry
    And enter "<Mobile>" mobile
    And Type "<Assign>" address
    And hit Register button
    Then  Assert that Registration should be successful




Examples:
|         Email              |      First Name   |      Last Name    |    passsword         |          Address             |     City        |       state      |    pincode   |       Countryy         |   Mobile  |   Assign              |
|    Tehelyani227@gmail.com  |      Tarun        |      Tehelyani    |    Test123          | 12 Boulevard Avenue          |    Chicago      |       Illinois   |    55555     |       United States   |   99999999   |   TarunT             |
|    RaunakPtl225@gmail.com  |      Raunak       |      Patel        |    Password123       | 12 Boulevard Avenue          |    Chicago      |      Illinois   |    66666     |       United States   |   88888888   |   RauNak             |
|    Gonu223@gmail.com         |      Gonu        |      Jha       |    Password123       | 12 Boulevard Avenue          |    Chicago      |       Illinois   |    77777     |       United States   |   66666666   |   GonuJ                  |
