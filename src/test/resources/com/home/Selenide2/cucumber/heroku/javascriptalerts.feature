Feature: Javascript alerts

  Background:
    Given url = "http://the-internet.herokuapp.com/javascript_alerts"

  Scenario:
    When "Click for JS Alert" is clicked
    Then alert is shown

  Scenario:
    When "Click for JS Confirm" is clicked
    Then confirm is shown

  Scenario:
    When "Click for JS Prompt" is clicked
    Then prompt is shown