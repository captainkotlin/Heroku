Feature: redirection
  
  Scenario: 
    When url requested "http://the-internet.herokuapp.com/redirect"
    Then url opened "http://the-internet.herokuapp.com/status_codes"