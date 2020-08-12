Feature: Floating menu

  Background:
    Given url = "http://the-internet.herokuapp.com/floating_menu"

  Scenario:
    Then menu has vertical offset

  Scenario:
    When page is scrolled down
    Then menu has no vertical offset