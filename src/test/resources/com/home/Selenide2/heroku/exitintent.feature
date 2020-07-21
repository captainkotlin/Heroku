Feature:

  Background:
    Given url = "http://the-internet.herokuapp.com/exit_intent"

  Scenario:
    When cursor is out of vision
    Then modal window is shown
