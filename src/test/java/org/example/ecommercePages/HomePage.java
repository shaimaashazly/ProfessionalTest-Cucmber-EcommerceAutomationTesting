package org.example.ecommercePages;

import org.example.ecommerceStepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage {
    int categoryRandomIndex;

    public WebElement CustomerCurrencySelector() {
        return Hooks.driver.findElement(By.id("customerCurrency"));

    }

    public ArrayList<String> productSearchList() {
        ArrayList<String> productsNameList = new ArrayList<>();
        List<WebElement> productsList = Hooks.driver.findElements(By.xpath("//*[@class='product-title']//a"));
        for (int i = 0; i < productsList.size(); i++) {
            productsNameList.add(productsList.get(i).getText());
        }
        return productsNameList;
    }

    public WebElement searchButton() {
        return Hooks.driver.findElement(By.xpath("//button[@type='submit']"));
    }

    public WebElement searchField() {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public List<WebElement> getCategories() {
        return Hooks.driver.findElements(By.cssSelector("ul[class = \"top-menu notmobile\"]>li>a[href]"));
    }

    public WebElement selectRandomCategory() {
        categoryRandomIndex = new Random().nextInt(3);
        List<WebElement> categories = getCategories();
        return categories.get(categoryRandomIndex);
    }

    public List<WebElement> getSubCategories() {
        int newIndex = categoryRandomIndex + 1;
        List<WebElement> subCategories = Hooks.driver.findElements(
                By.xpath(
                        "//ul[@class =\"top-menu notmobile\"]/li[" + newIndex + "]/ul" +
                                "[@class=\"sublist first-level\"]/li")
        );
        return subCategories;
    }

    public WebElement selectRandomSubCategory() {
        int subCategoryRandomIndex = new Random().nextInt(3);
        List<WebElement> subCategories = getSubCategories();
        return subCategories.get(subCategoryRandomIndex);
    }

    public String getPageTitle() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText();
    }

    public WebElement getNokiaSlider() {
        return Hooks.driver.findElement(By.xpath("//a[@href=\"http://demo.nopcommerce.com/\"][1]"));
    }

    public WebElement getIphoneSlider() {
        return Hooks.driver.findElement(By.xpath("//a[@href=\"http://demo.nopcommerce.com/\"][2]"));
    }

    public WebElement FacebookIcon() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
    }

    public WebElement TwitterIcon() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
    }

    public WebElement RssIcon() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"https://demo.nopcommerce.com/news/rss/1\"]"));
    }

    public WebElement YoutubeIcon() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }

    public List<WebElement> getWishlistButtons() {
        List<WebElement> elements = Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\""));
        return elements;
    }

    public WebElement wishListMessageBar() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    public WebElement getWishListQty() {
        return Hooks.driver.findElement(By.xpath("//input[@class='qty-input']"));
    }

    public WebElement getWishListTab() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"header-links-wrapper\"] a[href=\"/wishlist\"]"));
    }
}
