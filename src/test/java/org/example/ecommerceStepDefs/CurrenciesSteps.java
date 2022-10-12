package org.example.ecommerceStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ecommercePages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CurrenciesSteps {
    HomePage homePage = new HomePage();

    @When("Select euro currency from the dropdown list in the home page")
    public void selectEuroCurrency() {

        Select currencySelect = new Select(homePage.CustomerCurrencySelector());
        currencySelect.selectByVisibleText("Euro");
    }

    @Then("Euro Symbol is shown on the all products in the home page")
    public void euroSymbolIsShownOnTheAllProductsInTheHomePage() {
        List<WebElement> productsPrice = Hooks.driver.findElements(By.cssSelector("span[class =\"price actual-price\"]"));

        for (int i = 0; i < productsPrice.size(); i++) {

            String priceValue = productsPrice.get(i).getText();
            Assert.assertTrue(priceValue.contains("€"), " Wrong Currency Symbol");
        }

    }
}
