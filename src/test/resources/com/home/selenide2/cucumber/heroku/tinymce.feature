Feature: tinymce

  Background:
    Given url = "http://the-internet.herokuapp.com/tinymce"

  Scenario:
    Given iFrame is selected
    When text is typed:
        """
        Hello world
        """
    Then relevant field contais same text
