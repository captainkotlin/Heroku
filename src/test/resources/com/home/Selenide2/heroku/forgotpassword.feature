Feature: Forgot password

  Background:
    Given url = "http://the-internet.herokuapp.com/forgot_password"

  Scenario Outline:
    When email box is <emailbox>
    And send button clicked
    Then email is received

    Examples:
      | emailbox                                                         |
      | pop.gmail.com, pop3, captainkotlin@gmail.com, insertpasswordhere |