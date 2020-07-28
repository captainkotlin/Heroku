Feature: Slow loading

  Scenario:
    When url is opened "http://the-internet.herokuapp.com/slow_external"
    Then page is opened in 35 seconds with status 503