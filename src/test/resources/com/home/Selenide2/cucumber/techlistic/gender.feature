Feature: gender radiobuttons

  Background: open page
    Given url = "https://www.techlistic.com/p/selenium-practice-form.html"

  Scenario Outline: Check 'Gender' radiobuttons
    When <pressedGender> was pressed
    Then related item is selected

    Examples:
      | pressedGender |
      | Male          |
      | Female        |