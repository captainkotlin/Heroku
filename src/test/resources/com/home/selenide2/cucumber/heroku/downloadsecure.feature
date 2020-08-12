Feature: download secure

  Scenario:
    Given url = "http://the-internet.herokuapp.com/download_secure" with "admin" and "admin"
    Then list of files is displayed

