Feature: Basic Auth

  Scenario:
    Given basic auth url is "http://the-internet.herokuapp.com/basic_auth"
    When requested with user = "admin" and pass = "admin"
    Then authorization successful

