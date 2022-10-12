@smoke
Feature: Main_Features_Home_Slider | user can click on any slider and navigate to the product page

  Scenario: user can click on nokia slider
    When user click on nokia slider
    Then user navigate to nokia page with url "https://demo.nopcommerce.com/nokia-lumia-1020"


  Scenario: user click on iphone slider
    When user click on iphone slider
    Then user redirected to iphone page and the url will be "https://demo.nopcommerce.com/iphone-6"