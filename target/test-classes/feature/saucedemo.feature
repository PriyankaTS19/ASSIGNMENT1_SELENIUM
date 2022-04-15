Feature: Automate Saucedemo Site

  @scenario1
  Scenario: To verify adding multiple options in cart and checkout
    Given user is on saucedemo homepage
    And user logged in using correct credential
      | username | standard_user |
      | password | secret_sauce  |
    And user adds required item to cart
    And user proceeds to checkout
    And user enters the following details for checkout
      | FirstName  | abc    |
      | LastName   | def    |
      | PostalCode | 400087 |
    When user confirm checkout
    Then user verify final confirmation message

  @scenario2
  Scenario: To verify adding removing then adding and checkout
    Given user is on saucedemo homepage
    And user logged in using correct credential
      | username | standard_user |
      | password | secret_sauce  |
    And user adds one item and then remove that item to go back
    And user adds required item to cart
    And user proceeds to checkout
    And user enters the following details for checkout
      | FirstName  | abc    |
      | LastName   | def    |
      | PostalCode | 400087 |
    When user confirm checkout
    Then user verify final confirmation message

  @scenario3
  Scenario: To verify sort low to high
    Given user is on saucedemo homepage
    And user logged in using correct credential
      | username | standard_user |
      | password | secret_sauce  |
    And user sorts item low to high
    And user adds required item to cart
    And user proceeds to checkout
    And user enters the following details for checkout
      | FirstName  | abc    |
      | LastName   | def    |
      | PostalCode | 400087 |
    When user confirm checkout
    Then user verify final confirmation message
