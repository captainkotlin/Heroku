Feature: Broken images

  Background:
    Given url = "http://the-internet.herokuapp.com/broken_images"

  Scenario:
    Then image asdf contains real image under url