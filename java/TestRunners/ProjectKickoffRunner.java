package TestRunners;

import PageObjects.Device.AllPageObject;
import PageObjects.HomePageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static Utilities.Driver.setUrl;

public class ProjectKickoffRunner {
    @Given("Go to {string}")
    public static void goToUrl(String url) {
        setUrl(url);
    }

    @Then("Verify title of the page to be {string}")
    public void verifyPageTitle(String title) {
        HomePageObject.verifyPageTitleToBe(title);
    }

    @Given("Click on {string} menu")
    public void clickOnMenuItem(String menuItem) {
        HomePageObject.clickOnMenuItem(menuItem);
    }

    @Given("In the list of all mobile, select {string} dropdown as {string}")
    public void selectDropDown(String select, String value) {
        AllPageObject.selectDropDown(select, value);
    }

    @Then("Verify all products are sorted by name")
    public void verifyProductsSortedByName() {
        AllPageObject.verifyProductsSortedByName();
    }
}