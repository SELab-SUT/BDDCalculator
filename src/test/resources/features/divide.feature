@tag
Feature: Divide

  Scenario: divide two numbers
    Given Two input values, 4 and 2
    When I divide the two values
    Then I expect the result 2

  Scenario: divide by zero
    Given Two input values, -7 and 0
    When I divide the two values
    Then I expect the divide by zero exception

  Scenario Outline: divide by zero
    Given Two input values, <first> and <second>
    When I divide the two values
    Then I expect the result <result>
    Examples:
      | first | second | result |
      | 18    | 3      | 6      |
      | -320  | 16     | -20    |
      | -19   | -3     | 6      |
      | 21    | 185    | 0      |
