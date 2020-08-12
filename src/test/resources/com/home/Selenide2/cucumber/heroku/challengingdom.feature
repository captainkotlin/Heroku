@ignore
Feature: Challenging DOM

  Background:
    Given url = "http://the-internet.herokuapp.com/challenging_dom"

  Scenario:
    Then image contans "Answer:" and some number