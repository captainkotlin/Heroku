Feature: Hover

  Background:
    Given url = "http://the-internet.herokuapp.com/hovers"

  Scenario:
    When first image hovered
    Then View profile link is displayed