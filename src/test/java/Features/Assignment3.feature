
Feature:Register into Mercury Tours website
  @travel
  Scenario Outline:Enter Registration Details in Mercury Tours booking website
    Given i access url
    When i click Register link
    And enter the "<FirstName>" FirstName
    And enter the "<LastName>"  LastName
    And enter the "<Phone>"     Phone
    And enter the "<Email>"     Email
    And enter the "<City>"      City
    And enter the "<State>"     State
    And enter the "<postalcode>" Pincode
    And Select "<Country>"      Country
    And enter the "<UserName>"  UserName
    And enter the "<Password>"  Password
    And re-enter the "<ConfirmPassword>" Confirm Password
    And hit submit button
    Then  Registration should be successful
    And Verify the Username

    Examples:
     |  FirstName   |   LastName    |  Phone  |      Email                 |    City       |    State      |  postalcode          |       Country       |       UserName     |       Password    |   ConfirmPassword   |
     |  Rahul       |   Shetty      |  12345  |      123@gmail.com         |    Bangalore  |    Karnataka  |    560010            |       INDIA        |       Rahul         |       Rahul       |     Rahul           |
     |  Shankar     |   Raghavan    |  22222  |     Shankar@gmail.com      |    Delhi      |    Delhi      |    200100            |       INDIA        |       Shankar       |       Shankar     |     Shankar         |
     |  Anish       |   Sharma      |  33333  |      Anish@gmail.com       |    Chennai    |    TN         |    300101            |       INDIA        |       Anish         |       Anish       |     Anish           |
     |  Adhvik       |  Bhatia      |  10101  |      Adhvik@indiatimes.com |    Florida    |    FL         |    555555            |   UNITED STATES    |       Anish         |       Adhvik      |    Adhvik           |
     |  Satish       |  Kumar       |  191010  |     Satish@gmail.com      |    Chicago    |    IL         |    2534110           |   UNITED STATES    |       Satish        |       Kumar       |    Kumar            |
     |  Albert      |  Pinto       |  348912  |     Apinto@yahoo.com       |    Singapore  |  Singapore     |   981110            |   SINGAPORE       |       Albert        |       password      |    password       |
     |  Gauri      |  Khan        |  400001  |       Gauri@aol.com         |   Mumbai     |  Maharashtra   |   400001              |   INDIA           |       Gauri          |      Khan          |    Khan             |
     |  Manu      |  Chopra       |  4562737  |      Manu.s@yahoo.com      |   Pune     |  Maharashtra   |      471001             |   INDIA           |       Manu         |      Manu         |    Manu            |

