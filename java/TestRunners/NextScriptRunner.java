package TestRunners;

import PageObjects.Device.AllPageObject;
import PageObjects.Device.DetailPageObject;
import io.cucumber.java.en.Given;

public class NextScriptRunner {
    protected static String costAllPage;
    protected static String costDetailPage;

    @Given("Read the cost of {string} mobile from all mobile page")
    public void readMobileCostFromAll(String mobile) {
        costAllPage = AllPageObject.getCost(mobile);
    }

    @Given("Click on {string} mobile")
    public void getMobileDetail(String mobile) {
        AllPageObject.getMobileDetail(mobile);
    }

    @Given("Read the cost of {string} mobile from detailed mobile page")
    public void readMobileCostFromDetail(String mobile) {
        costDetailPage = DetailPageObject.getCost(mobile);
    }

    @Given("Compare value in and detailed mobile page")
    public void compareValue() {
        DetailPageObject.compareValue(costAllPage, costDetailPage);
    }
}