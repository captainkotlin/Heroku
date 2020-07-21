Feature: File download

  Scenario:
    Given url with list of files "http://the-internet.herokuapp.com/download"
    When href is pressed "download/luminoslogo.png"
    Then file is downloaded