Feature: firstname field

  Background: open page
    Given url = "https://www.techlistic.com/p/selenium-practice-form.html"

  Scenario Outline: Check 'First name' field
    Given 'First name' field is selected
    When text <expectedtext> was sent to 'First name'
    Then 'First name' is <actualtext>

    Examples:
      | expectedtext | actualtext |
      | Alexander    | Alexander  |
      | Bobby        | Bobby      |