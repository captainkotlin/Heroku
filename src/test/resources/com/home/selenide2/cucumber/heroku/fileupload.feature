Feature: File upload

  Background:
    Given url = "http://the-internet.herokuapp.com/upload"

  Scenario:
    Given path to file "build.gradle"
    When upload button pressed
    Then uploaded files contains build.gradle
