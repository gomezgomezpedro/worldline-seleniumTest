Feature: Google search

  # Google search test
  Scenario: User makes a search in Google
    When the user inputs Hola as a search value
    And the user clicks the Search button
    Then at least one result is displayed