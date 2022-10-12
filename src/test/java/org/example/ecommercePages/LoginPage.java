package org.example.ecommercePages;

import org.example.ecommerceStepDefs.Hooks;
import org.example.ecommerceStepDefs.LoginSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebElement loginLink() {
        return Hooks.driver.findElement(By.className("ico-login"));
    }

    public WebElement emailField() {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement passwordField() {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement loginButton() {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }
}
