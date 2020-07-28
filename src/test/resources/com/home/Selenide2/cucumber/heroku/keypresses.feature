Feature: Key presses

  Background:
    Given url = "http://the-internet.herokuapp.com/key_presses"

  Scenario:
    When "Hello world" pressed
    Then element contains text "Hello world"