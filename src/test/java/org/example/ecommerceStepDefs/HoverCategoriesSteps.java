package org.example.ecommerceStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ecommercePages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Random;

public class HoverCategoriesSteps {
    HomePage homePage = new HomePage();
    String selectedMainCategory;
    String subCategoryName;

    @When("user hover on main categories")
    public void hoverOnRandomCategory() throws InterruptedException {
        WebElement randomCategory = homePage.selectRandomCategory();
        selectedMainCategory = randomCategory.getText();
        Actions hoverAction = new Actions(Hooks.driver);
        hoverAction.moveToElement(randomCategory).perform();
        Thread.sleep(1000);
    }


    @And("user can select random one of the three sub categories")
    public void userCanSelectRandomOneOfTheThreeSubCategories() throws InterruptedException {
        WebElement randomSubCategory = homePage.selectRandomSubCategory();
        subCategoryName = randomSubCategory.getText();
        System.out.println("Sub Category Name : " + subCategoryName);
        randomSubCategory.click();
        Thread.sleep(1000);
    }

    @Then("user redirected to sub category page")
    public void userRedirectedToSubCategoryPage() {
        String pageTitle = homePage.getPageTitle().toLowerCase().trim();
        Assert.assertTrue(pageTitle.contains(subCategoryName.toLowerCase().trim()), "Wrong Page Title");
    }
}
