Feature: Context Menu

  Background:
    Given url = "http://the-internet.herokuapp.com/context_menu"

  Scenario:
    When right click is done on field
    Then handle alert