Feature: notification message

  Background:
    Given url = "http://the-internet.herokuapp.com/notification_message_rendered"

    Scenario:
      Then header text matches regex Action (.*)\s*.*