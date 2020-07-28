Feature: Input

  Background:
    Given url = "http://the-internet.herokuapp.com/inputs"

  Scenario:
    When "125" is typed
    Then field is filled with "125"