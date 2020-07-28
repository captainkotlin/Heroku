Feature: Digest auth

  Scenario:
    Given url is "http://the-internet.herokuapp.com/digest_auth"
    When login is tried with user = "admin" and password = "admin"
    Then login is successful

