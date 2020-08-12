Feature: typos

  Background:
    Given url = "http://the-internet.herokuapp.com/typos"

  Scenario:
    Given Repeat count = 10
    And repeat action is refresh
    Then text is:
    """
    Sometimes you'll see a typo, other times you won't.
    """

