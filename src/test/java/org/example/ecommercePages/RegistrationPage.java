package org.example.ecommercePages;

import org.example.ecommerceStepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    public WebElement registrationLink() {
        return Hooks.driver.findElement(By.className("ico-register"));
    }

    public WebElement firstNameField() {
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement lastNameField() {
        return Hooks.driver.findElement(By.id("LastName"));
    }

    public WebElement emailField() {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement passwordField() {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement confirmPassField() {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement dateOfBirthday() {
        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement dateOfBirthMonth() {
        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement dateOfBirthYear() {
        return Hooks.driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement userGenderMale() {
        return Hooks.driver.findElement(By.id("gender-male"));
    }

    public WebElement userGenderFemale() {
        return Hooks.driver.findElement(By.id("gender-female"));
    }

    public WebElement companyName(){
        return Hooks.driver.findElement(By.id("Company"));
    }

    public WebElement registerButton(){
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public WebElement registrationMessage(){
        return Hooks.driver.findElement(By.className("result"));
    }
}
