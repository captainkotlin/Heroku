Feature: lastname field

  Background: open page
    Given url = "https://www.techlistic.com/p/selenium-practice-form.html"

  Scenario Outline: Check 'Last name' field
    Given 'Last name' field is selected
    When text <expectedtext> was sent to 'Last name'
    Then 'Last name' is <actualtext>

    Examples:
      | expectedtext | actualtext |
      | Zavaliy      | Zavaliy    |
      | Holopainen   | Holopainen |