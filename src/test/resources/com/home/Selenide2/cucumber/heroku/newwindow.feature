Feature: New window

  Background:
    Given url = "http://the-internet.herokuapp.com/windows"

  Scenario:
    When button clicked
    Then new window was opened
