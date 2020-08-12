Feature: Dropdown

  Background:
    Given url = "http://the-internet.herokuapp.com/dropdown"
    
  Scenario: 
    When "Option 2" is selected
    Then selected value is "Option 2"