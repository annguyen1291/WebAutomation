package PageObjects.Device;

import PageObjects.BasePageObject;
import com.google.common.collect.Comparators;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AllPageObject extends BasePageObject {
    protected static String productNameXPath = "//h2[@class='product-name']";

    public static void selectDropDown(String select, String value) {
        String selectXPath = "//select[@title='" + select + "']";
        selectByText(selectXPath, value);
    }

    public static void verifyProductsSortedByName() {
        String selectXPath = "//ul[contains(@class,'products-grid')]//h2[@class='product-name']";
        List<WebElement> products = locateMultiple(selectXPath);
        List<String> productNames = new ArrayList<>();
        products.forEach(product -> {
            productNames.add(product.getText());
        });
        assertTrue(Comparators.isInOrder(productNames, Comparator.naturalOrder()));
    }

    public static String getCost(String mobile) {
        String costAllPageXPath = productNameXPath + "/a[text()='" + mobile + "']/../../div[@class='price-box']";
        return getText(costAllPageXPath);
    }

    public static void getMobileDetail(String mobile) {
        String mobileDetailXPath = productNameXPath + "/a[text()='" + mobile + "']";
        click(mobileDetailXPath);
    }

    public static void addToCompare(String item) {
        String addToCompareXPath = productNameXPath + "/a[text()='" + item + "']/../..//a[text()='Add to Compare']";
        click(addToCompareXPath);
    }

    public static void clickCompareButton() {
        String compareButtonXPath = "//ol[@id='compare-items']/..//button//span[text()='Compare']";
        click(compareButtonXPath);
    }

    public static void addToWishlist(String item) {
        String addToWishlistXPath = productNameXPath + "/a[text()='" + item + "']/../..//a[text()='Add to Wishlist']";
        click(addToWishlistXPath);
    }
}
