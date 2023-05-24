package PageObjects.Device;

import PageObjects.BasePageObject;

import static org.junit.Assert.assertEquals;

public class DetailPageObject extends BasePageObject {
    public static String getCost(String mobile) {
        String costDetailPageXPath = "//div[@class='product-name']/span[text()='" + mobile + "']/../../div[@class='price-box']";
        return getText(costDetailPageXPath);
    }

    public static void compareValue(String costAllPage, String costDetailPage) {
        assertEquals(costAllPage, costDetailPage);
    }
}
