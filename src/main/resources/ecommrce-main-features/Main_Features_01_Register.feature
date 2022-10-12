@smoke
Feature: Main_Features_Register | users could register with new accounts


  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When user select gender type
    And user enter his first name "automation"
    And user enter his last name "tester"
    And user enter date of birth
    And user enter email "test@example.com" field
    And  user enter company name "Udacity"
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then success message is displayed
