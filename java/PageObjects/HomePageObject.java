package PageObjects;

import static junit.framework.TestCase.assertEquals;

public class HomePageObject extends BasePageObject {
    public static void verifyPageTitleToBe(String pageTitle) {
        String pageTitleXPath = "//div[contains(@class,'page-title')]";
        assertEquals(getText(pageTitleXPath), pageTitle);
    }

    public static void clickOnMenuItem(String menuItem) {
        String menuItemXPath = "//div[@id='header-nav']//a[text()='" + menuItem + "']";
        click(menuItemXPath);
    }

    public static void navigateToAccountItem(String menuItem) {
        click("//a[@data-target-element='#header-account']");
        String accountItemXPath = "//div[@id='header-account']//a[text()='" + menuItem + "']";
        click(accountItemXPath);
    }
}
