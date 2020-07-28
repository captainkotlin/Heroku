Feature: status code

  Scenario:
    Then status code of page matches expected:
      | page                                               | statusCode |
      | http://the-internet.herokuapp.com/status_codes/200 | 200        |
      | http://the-internet.herokuapp.com/status_codes/301 | 301        |
      | http://the-internet.herokuapp.com/status_codes/404 | 404        |
      | http://the-internet.herokuapp.com/status_codes/500 | 500        |