Feature: Checkboxes

  Background:
    Given url = "http://the-internet.herokuapp.com/checkboxes"

  Scenario:
    When checkbox1 was selected
    Then checkbox1 is selected

  Scenario:
    When checkbox2 was selected
    Then checkbox2 is selected