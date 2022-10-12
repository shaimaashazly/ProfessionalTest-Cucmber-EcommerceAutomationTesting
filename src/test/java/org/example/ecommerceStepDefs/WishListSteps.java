package org.example.ecommerceStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ecommercePages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class WishListSteps {
    HomePage homePage = new HomePage();

    @When("user click on add to wishlist on the third item")
    public void clickOnWishListButton() {
        homePage.getWishlistButtons().get(2).click();
    }

    @Then("success message {string} with green background color")
    public void successMessageWithGreenBackgroundColor(String expectedMessage) throws InterruptedException {
        Thread.sleep(2000);

        SoftAssert soft = new SoftAssert();

        String actualMessage = homePage.wishListMessageBar().getText();
        String actualMessageColor = homePage.wishListMessageBar().getCssValue("background-color");
        String expectedMessageColor = "rgba(75, 176, 122, 1)"; // green color in rgba

        soft.assertTrue(expectedMessage.contains(actualMessage), "Wrong wishlist message");
        soft.assertTrue(actualMessageColor.equals(expectedMessageColor), "Wrong Color Message ");

        soft.assertAll();
    }



    @And("click on wishList tab")
    public void clickOnWishListTab() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(homePage.wishListMessageBar()));
        homePage.getWishListTab().click();
    }

    @Then("verify the number of wishlist items increased")
    public void verifyTheNumberOfWishlistItemsIncreased() {

        String qty = homePage.getWishListQty().getAttribute("value");
        System.out.println("QTY : " + qty);

        SoftAssert soft = new SoftAssert();
        int actualQty = Hooks.convertStringToInt(qty);
        soft.assertTrue(actualQty > 0, "Quantity didn't increased");
        soft.assertAll();
    }
}
