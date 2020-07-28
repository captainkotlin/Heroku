Feature: Nested frames

  Background:
    Given url = "http://the-internet.herokuapp.com/nested_frames"

  Scenario Outline:
    When <src> frame is selected
    Then body tags is <text>

    Examples:
      | src                   | text  |
      | frame-top,frame-left  | LEFT  |
      | frame-top,frame-right | RIGHT |