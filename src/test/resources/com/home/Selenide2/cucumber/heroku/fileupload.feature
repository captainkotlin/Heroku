Feature: File upload

  Background:
    Given url = "http://the-internet.herokuapp.com/upload"

  Scenario:
    Given path to file "/home/alexander/Downloads/0.jpg"
    When upload button pressed
    Then uploaded files contains 0.jpg
