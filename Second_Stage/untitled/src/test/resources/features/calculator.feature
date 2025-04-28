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
