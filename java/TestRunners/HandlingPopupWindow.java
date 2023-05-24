package TestRunners;

import PageObjects.Device.AllPageObject;
import PageObjects.Device.ComparePageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HandlingPopupWindow {
    @And("Add {string} to compare")
    public void addToCompare(String item) {
        AllPageObject.addToCompare(item);
    }

    @Given("Click on \"Compare\" button")
    public void clickCompareButton() {
        AllPageObject.clickCompareButton();
    }

    @Then("Verify the pop-up window and check that {string} and {string} are reflected in it")
    public void verifyDetail(String mobile1, String mobile2) {
        ComparePageObject.switchToCompareWindow();
        ComparePageObject.verifyMobile(mobile1);
        ComparePageObject.verifyMobile(mobile2);
    }

    @Then("Close the pop-up window")
    public void compareValue() {
        ComparePageObject.closePopupWindow();
    }
}