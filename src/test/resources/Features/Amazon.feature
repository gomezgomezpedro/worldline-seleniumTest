@AmazonPLP
Feature: Amazon
  As a user I want to make a purchase in Amazon web.
  The process to make the purchase is: find an article, go to the article page, add it to the cart and validate the cart.

  Background:
    Given the user accepts the cookie preferences

  # Amazon PLP navigation and add product to cart
  Scenario Outline: Find a product and add it to the cart
    When the user types <search_term> in the search bar
    And clicks the submit search button
    Then at least one result is displayed
    When the user accesses the first result product page
    And adds the product to the cart
    And accesses the cart page
    Then the product previously added to the cart is displayed correctly

    Examples:
      | search_term |
      | mug         |
