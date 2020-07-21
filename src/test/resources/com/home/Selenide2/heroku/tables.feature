Feature: tables

  Background:
    Given url = "http://the-internet.herokuapp.com/tables"

  Scenario Outline: HOHO
    When Button with <sortType> and ascending status <asc> is pressed
    Then table1 is sorted correctly

    Examples:
      | sortType   | asc   |
      | Last Name  | true  |
      | Last Name  | false |
      | First Name | true  |
      | First Name | false |
      | Email      | true  |
      | Email      | false |
      | Due        | true  |
      | Due        | false |
      | Web Site   | true  |
      | Web Site   | false |
