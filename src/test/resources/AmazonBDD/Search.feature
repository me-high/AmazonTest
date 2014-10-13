Feature: Testing for search functionality

  Scenario: Search Product
    Given I want to use the browser Firefox
    When I type iPhone in the search input field
    And I click the Go button
    Then I am on the search results page
    And I verify the price for first 5 results
      | resultNo | productName                          | price   |
      | 1        | iPhone 5c                            | £386.00 |
      | 2        | iPhone 5, White                      | £379.99 |
      | 3        | iPhone 4 16GB                        | £219.00 |
      | 4        | iPhone 5s                            | £508.00 |
      | 5        | Apple 16GB iPod Touch 5th Generation | £135.00 |

#  Scenario: Search Product2
#    Given I want to use the browser Firefox
#    When I type ipod in the search input field
#    And I click the Go button
#    Then I am on the search results page