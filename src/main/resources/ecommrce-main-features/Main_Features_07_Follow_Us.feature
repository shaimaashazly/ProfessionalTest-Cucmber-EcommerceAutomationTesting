@smoke
Feature: Main_Features_Follow_Us | users could open followUs links

  Scenario: user clicks on facebook icon
    When user clicks on  facebook icon
    Then "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: user clicks on  twitter icon
    When user opens twitter link
    Then "https://twitter.com/nopCommerce" is opened in new tab

  Scenario: user clicks on rss icon
    When user opens rss link
    Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

  Scenario: user clicks on youtube icon
    When user opens youtube link
    Then "https://www.youtube.com/user/nopCommerce" is opened in new tab