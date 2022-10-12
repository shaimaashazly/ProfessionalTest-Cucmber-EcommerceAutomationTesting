package org.example.ecommerceStepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver = null;

    @Before
    public void openBrowser() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";

        // 1 bridge between test scripts and browser
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @After
    public void exitBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public static int convertStringToInt(String stringNumber) {
        String value = stringNumber.replaceAll("[^0-9]", "");
        return Integer.parseInt(value);
    }

}
