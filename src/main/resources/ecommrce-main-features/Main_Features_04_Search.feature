@smoke
Feature: Main_Features_Search | users could search for products using product name and sku

  Scenario Outline: user could search using product "<name>"
    When user search using product "<name>"
    Then user navigated to another search link with product "<name>"
    Examples:
      | name   |
      | Book   |
      | Laptop |
      | Nike   |

  Scenario Outline: user could search using product "<sku>"
    When user search using product "<sku>"
    Then user navigated to another search link with productSku "<sku>"
    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |