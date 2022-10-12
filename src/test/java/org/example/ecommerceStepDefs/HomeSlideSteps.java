package org.example.ecommerceStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ecommercePages.HomePage;
import org.testng.asserts.SoftAssert;

public class HomeSlideSteps {
    HomePage homePage = new HomePage();
    SoftAssert sAssert = new SoftAssert();

    @When("user click on nokia slider")
    public void clickOnNokiaSlider() {
        homePage.getNokiaSlider().click();

    }

    @Then("user navigate to nokia page with url {string}")
    public void userNavigateToNokiaPageWithUrl(String expectedUrl) {
        String currentUrl = Hooks.driver.getCurrentUrl();
        System.out.println("Nokia Slider / Current Url " + currentUrl);
        sAssert.assertTrue(expectedUrl.equals(currentUrl), "Wrong nokia Url ");
        sAssert.assertAll();

    }

    @When("user click on iphone slider")
    public void userClickOnIphoneSlider() {
        homePage.getIphoneSlider().click();
    }

    @Then("user redirected to iphone page and the url will be {string}")
    public void userRedirectedToIphonePageAndTheUrlWillBe(String expectedUrl) {
        String currentUrl = Hooks.driver.getCurrentUrl();
        System.out.println("Iphone Slider / Current Url " + currentUrl);
        sAssert.assertTrue(expectedUrl.equals(currentUrl), "Wrong iphone Url ");
        sAssert.assertAll();
    }
}
