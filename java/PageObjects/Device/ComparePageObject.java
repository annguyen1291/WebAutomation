package PageObjects.Device;

import PageObjects.BasePageObject;

import static Utilities.Driver.driver;
import static org.junit.Assert.assertEquals;

public class ComparePageObject extends BasePageObject {
    static String originalWindow;

    public static void switchToCompareWindow() {
        originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void verifyMobile(String mobile) {
        String mobileXPath = "//table[contains(@class, 'compare-table')]//h2[@class='product-name']/a[text()='" + mobile + "']";
        assertEquals(getText(mobileXPath), mobile.toUpperCase());
    }

    public static void closePopupWindow() {
        driver.close();
        driver.switchTo().window(originalWindow);
    }
}
