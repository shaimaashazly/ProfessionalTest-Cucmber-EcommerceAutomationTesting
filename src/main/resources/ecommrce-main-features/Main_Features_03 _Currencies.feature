@smoke
Feature: Main_Features_Currencies | users could select euro currency

  Scenario: user could select Euro Currency successfully and all items shows with the euro symbol
    When Select euro currency from the dropdown list in the home page
    Then Euro Symbol is shown on the all products in the home page