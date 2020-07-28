Feature: shadow dom

  Background:
    Given url = "http://the-internet.herokuapp.com/shadowdom"

  Scenario:
    Then span contains text: "Let's have some different text!"