Feature: Horizontal slider

  Background:
    Given url = "http://the-internet.herokuapp.com/horizontal_slider"

  Scenario:
    When slider moved to top right
    Then slider value is "5"