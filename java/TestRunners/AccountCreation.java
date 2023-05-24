package TestRunners;

import PageObjects.Account.RegisterPageObject;
import PageObjects.Account.WishlistPageObject;
import PageObjects.Device.AllPageObject;
import PageObjects.HomePageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static TestData.CustomerData.customer;

public class AccountCreation {
    protected Map<String, String> customer = customer();

    @When("Click on \"Account\" button then {string} menu")
    public void navigateToAccountItem(String menuItem) {
        HomePageObject.navigateToAccountItem(menuItem);
    }

    @And("Fill in new user information")
    public void fillInNewUserInformation() {
        RegisterPageObject.fillInNewUserInformation(customer);
    }

    @And("Click on \"Register\" button")
    public void clickOnRegister() {
        RegisterPageObject.clickOnRegister();
    }

    @Then("Verify registration is done")
    public void verifyRegistration() {
        RegisterPageObject.verifyRegistration();
    }

    @And("Add {string} to wishlist")
    public void addToWishlist(String item) {
        AllPageObject.addToWishlist(item);
    }

    @And("Click on \"Share Wishlist\" button")
    public void clickOnShareWishList() {
        WishlistPageObject.clickOnShareWishList();
    }

    @And("Enter email and share wishlist")
    public void enterEmailAndShareWishlist() {
        WishlistPageObject.enterEmailAndShareWishlist(customer.get("email"));
    }

    @Then("Verify wishlist is shared")
    public void verifySharingWishlist() {
        WishlistPageObject.verifySharingWishlist();
    }
}