package org.example.ecommerceStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ecommercePages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class SearchSteps {
    HomePage homePage = new HomePage();

    @When("user search using product \"<name>\"")
    public void searchUsingProductName(String name) {
        homePage.searchField().sendKeys(name);
        homePage.searchButton().click();
    }

    @When("user search using product {string}")
    public void userSearchUsingProductSku(String arg0) {
        homePage.searchField().sendKeys(arg0);
        homePage.searchButton().click();
    }

    @Then("user navigated to another search link with product {string}")
    public void userNavigatedToAnotherSearchLinkWithProduct(String arg0) {

        System.out.println("Send Key Is " + arg0);
        SoftAssert softAssert = new SoftAssert();

        String currentUrl = Hooks.driver.getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains(arg0), "Wrong URL Result");

        ArrayList<String> names = homePage.productSearchList();
        softAssert.assertTrue(names.size() > 0, "Search result size = 0 ");

        for (int i = 0; i < names.size(); i++) {
            String productName = names.get(i).toLowerCase();
            System.out.println("Product Name : " + productName);
            softAssert.assertTrue(productName.contains(arg0.toLowerCase()), "result number " + i + " is wrong");
        }
        softAssert.assertAll();
    }

    @Then("user navigated to another search link with productSku {string}")
    public void userNavigatedToAnotherSearchLinkWithProductSku(String arg0) {

        List<WebElement> productsList = Hooks.driver.findElements(By.xpath("//*[@class='product-title']//a"));
        for (int i = 0; i < productsList.size(); i++) {
            WebElement product = productsList.get(i);
            product.click();
            String productSku = Hooks.driver.findElement(By.xpath("//div[@class='sku']//span[@class='value']")).getText();
            Assert.assertTrue(productSku.equalsIgnoreCase(arg0));
        }
    }
}
