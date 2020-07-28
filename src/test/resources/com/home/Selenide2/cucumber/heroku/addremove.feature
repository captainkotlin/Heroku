Feature: Add remove

  Background:
    Given url = "http://the-internet.herokuapp.com/add_remove_elements/"

  Scenario:
    When button "Add Element" is pressed
    Then "Delete" button is shown
    When "Delete" button is pressed
    Then Then "Delete" button is removed