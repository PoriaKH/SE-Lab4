Feature: Calculator
  We want to perform production (multiplication), division, and power operations.

  Scenario: Multiply two numbers
    Given the first number is 6
    And the second number is -2
    When I multiply the two numbers
    Then the result should be -12

  Scenario: Divide two numbers
    Given the first number is 6
    And the second number is 2
    When I divide the first number by the second number
    Then the result should be 3

  Scenario: Power of two numbers
    Given the first number is 6
    And the second number is -2
    When I raise the first number to the power of the second number
    Then the result should be 0
#    6 ^ -2 = 1/36 -> (int) = 0


#Feature: Calculator operations
#  We want to perform production (multiplication), division, and power operations.
#
#  Scenario Outline: Perform an operation on two numbers
#    Given the first number is <first>
#    And the second number is <second>
#    When I perform the "<opt>" operation
#    Then the result should be <result>
#
#    Examples:
#      | first | second | opt | result |
#      | 6     | -2      | *   | -12     |
#      | -6     | 2      | /   | -3      |
#      | 6     | -2      | ^   | 0     |
