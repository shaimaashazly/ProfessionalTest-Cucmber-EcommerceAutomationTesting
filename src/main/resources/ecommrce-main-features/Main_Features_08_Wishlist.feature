@smoke
Feature: Main_Features_08_Wishlist | user can add any product from homepage in his wishlist and find this product in the wishlist

  Scenario: user can click on wishlist button
    When user click on add to wishlist on the third item
    Then success message "The product has been added to your wishlist" with green background color

  Scenario: user can click on wishlist button
    When user click on add to wishlist on the third item
    And click on wishList tab
    Then verify the number of wishlist items increased