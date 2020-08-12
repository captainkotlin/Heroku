Feature: Shifting content

  Scenario Outline:
    Given screenshot opened "http://the-internet.herokuapp.com/shifting_content/menu?pixel_shift=0"
    When page <screenshotUrl> is opened
    Then comparisonStatus is <comparisonStatus>

    Examples:
      | screenshotUrl                                                           | comparisonStatus |
      | http://the-internet.herokuapp.com/shifting_content/menu?pixel_shift=0   | true             |
      | http://the-internet.herokuapp.com/shifting_content/menu?pixel_shift=100 | false            |