package org.example.ecommerceStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ecommercePages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("user go to login page")
    public void openLoginPage() {
        loginPage.loginLink().click();
    }

    @When("user login with valid {string} and {string}")
    public void userLoginWithValidAnd(String arg0, String arg1) {
        loginPage.emailField().sendKeys(arg0);
        loginPage.passwordField().sendKeys(arg1);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        loginPage.loginButton().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() throws InterruptedException {
        Hooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String actualURL = Hooks.driver.getCurrentUrl();
        System.out.println("CURRENT URL : " + actualURL);
        String expectedURL = "https://demo.nopcommerce.com/";

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(actualURL.equals(expectedURL), "Wrong URL");

        soft.assertTrue(Hooks.driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed(), "Tab Not Appear");

        soft.assertAll();
    }

    @When("user login with invalid {string} and {string}")
    public void userLoginWithInvalidAnd(String arg0, String arg1) {
        loginPage.emailField().sendKeys(arg0);
        loginPage.passwordField().sendKeys(arg1);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {

        Hooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement actualMessage = Hooks.driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessageText = actualMessage.getText();
        String expectedMessage = "Login was unsuccessful";

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(actualMessageText.contains(expectedMessage), "Wrong Error Message");

        String actualMessageColor = actualMessage.getCssValue("color");
        String expectedMessageColor = "#e4434b";

        soft.assertTrue(Color.fromString(actualMessageColor).asHex().equals(expectedMessageColor), "Wrong Color Message ");

        soft.assertAll();
    }
}


