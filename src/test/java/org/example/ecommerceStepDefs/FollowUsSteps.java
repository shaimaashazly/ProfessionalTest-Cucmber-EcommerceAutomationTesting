package org.example.ecommerceStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ecommercePages.HomePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class FollowUsSteps {
    HomePage homePage = new HomePage();
    int facebookIcon = 1, twitterIcon = 2, rssIcon = 3, youtubeIcon = 4;
    int clickedIcon;

    @When("user clicks on  facebook icon")
    public void userClicksOnFacebookIcon() {
        homePage.FacebookIcon().click();
        clickedIcon = facebookIcon;
    }

    @When("user opens twitter link")
    public void userOpensTwitterLink() {
        homePage.TwitterIcon().click();
        clickedIcon = twitterIcon;
    }

    @When("user opens rss link")
    public void userOpensRssLink() {
        homePage.RssIcon().click();
        clickedIcon = rssIcon;
    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink() {
        homePage.YoutubeIcon().click();
        clickedIcon = youtubeIcon;
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String expectedUrl) throws InterruptedException {

        System.out.println("Current Url " + Hooks.driver.getCurrentUrl());
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        String tabUrl = Hooks.driver.getCurrentUrl();
        switch (clickedIcon) {
            case 1:
                Assert.assertTrue(tabUrl.equals(expectedUrl), "Wrong Facebook Url ");
                break;
            case 2:
                Assert.assertTrue(tabUrl.equals(expectedUrl), "Wrong Twitter Url ");
                break;
            case 3:
                Assert.assertTrue(tabUrl.equals(expectedUrl), "Wrong Rss Url ");
                break;
            case 4:
                Assert.assertTrue(tabUrl.equals(expectedUrl), "Wrong Youtube Url ");
                break;
        }


    }
}
