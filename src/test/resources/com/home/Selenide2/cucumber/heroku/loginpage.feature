Feature: Login page

  Background:
    Given url = "http://the-internet.herokuapp.com/login"

  Scenario Outline:
    When <username> and <password> entered
    Then login result = <loginresult>

    Examples:
      | username | password             | loginresult |
      | A        | B                    | false       |
      | tomsmith | SuperSecretPassword! | true        |

