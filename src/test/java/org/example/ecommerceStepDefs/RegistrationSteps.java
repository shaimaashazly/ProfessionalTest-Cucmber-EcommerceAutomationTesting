package org.example.ecommerceStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ecommercePages.RegistrationPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class RegistrationSteps {
    RegistrationPage regPage = new RegistrationPage();

    @Given("user go to register page")

    public void openRegistrationPage() {
        WebElement registrationLink = regPage.registrationLink();
        registrationLink.click();
    }

    @When("user select gender type")
    public void userSelectGenderType() {
        WebElement femaleGender = regPage.userGenderFemale();
        femaleGender.click();
    }

    @And("user enter his first name {string}")
    public void userEnterHisFirstName(String arg0) {
        WebElement fName = regPage.firstNameField();
        fName.sendKeys(arg0);
    }

    @And("user enter his last name {string}")
    public void userEnterHisLastName(String arg0) {
        WebElement lName = regPage.lastNameField();
        lName.sendKeys(arg0);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        Select dayOfBirthday = new Select(regPage.dateOfBirthday());
        Select monthOfBirthday = new Select(regPage.dateOfBirthMonth());
        Select yearOfBirthday = new Select(regPage.dateOfBirthYear());

        dayOfBirthday.selectByVisibleText("21");
        monthOfBirthday.selectByVisibleText("May");
        yearOfBirthday.selectByVisibleText("1990");
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String arg0) {
        WebElement email = regPage.emailField();
        email.sendKeys(arg0);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) throws InterruptedException {
        WebElement password = regPage.passwordField();
        password.sendKeys(arg0);

        WebElement confirmPass = regPage.confirmPassField();
        confirmPass.sendKeys(arg1);

        Thread.sleep(2000);


    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        regPage.registerButton().click();
    }

    @And("user enter company name {string}")
    public void userEnterCompanyName(String arg0) {
        regPage.companyName().sendKeys(arg0);
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert soft = new SoftAssert();
        String actualMessage = regPage.registrationMessage().getText();
        String expectedMessage = "Your registration completed";
        soft.assertTrue(expectedMessage.equalsIgnoreCase(actualMessage), "Registration Fails");
        String actualColor = regPage.registrationMessage().getCssValue("color");
        System.out.println("Color : " + actualColor);
        String expectedColor = "rgba(76, 177, 124, 1)";
        soft.assertTrue(actualColor.contains(expectedColor), "Wrong Color Message");

        soft.assertAll();

    }
}
