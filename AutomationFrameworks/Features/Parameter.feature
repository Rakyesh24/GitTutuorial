Feature: Passing Parameter

@tag2
  Scenario Outline: Login with example
  When Login page is open "https://mail.rediff.com/cgi-bin/login.cgi" 
    Given I want to write a step with "<user>"
    When I check for the "<password>" in step
   Then I verify the "<status>" in step

   Examples: 
    | user  | password | status  |
      | Selenium |     Seleniuim123 | fail |
      | Test |     Selenium  | fail    |
      | Dan | North | fail |
      |  jason  | huggins  |  fail |