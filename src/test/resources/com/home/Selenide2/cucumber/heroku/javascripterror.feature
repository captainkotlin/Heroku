Feature: Javascript error

  Background:
    Given url = "http://the-internet.herokuapp.com/javascript_error"

  Scenario:
    Then log contains error