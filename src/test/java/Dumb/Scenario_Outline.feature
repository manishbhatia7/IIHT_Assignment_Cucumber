Feature:Login into account
  Scenario Outline:Login to account with credentials
    Given i access "<url>"
    When i click on login portal button
    And i enter the "<username>" username
    And i enter the "<password>" password
    And clicks on login button
    Then  User should be prompted with following alert "<message>"

    Examples:
     |            url                         |     username    |         password        |     message            |
     |  http://www.webdriveruniversity.com    |   user1         |         pass1           | validation failed      |
     |  http://www.webdriveruniversity.com    |   webdriver     |         webdriver123    | validation succeeded  |



