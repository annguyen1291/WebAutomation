package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Utilities.Driver.driver;

public class BasePageObject {
    protected static JavascriptExecutor executor = (JavascriptExecutor) driver;

    protected static WebElement locate(String XPath) {
        return explicitWait(5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPath)));
    }

    protected static List<WebElement> locateMultiple(String XPath) {
        waitVisible(XPath);
        return driver.findElements(By.xpath(XPath));
    }

    // Common
    protected static void click(String XPath) {
        locate(XPath).click();
    }

    protected static void type(String XPath, String value) {
        locate(XPath).sendKeys(Keys.CONTROL + "a");
        locate(XPath).sendKeys(value);
    }

    // Alert
    protected static String alert(String action, int timeout) {
        try {
            Alert alert = explicitWait(timeout).until(ExpectedConditions.alertIsPresent());
            switch (action) {
                case "dismiss":
                    alert.dismiss();
                case "accept":
                    alert.accept();
                default: // getText
                    return alert.getText();
            }
        } catch (Exception e) {
            return "";
        }
    }

    protected static String alert(String action) {
        return alert(action, 1);
    }

    // Select
    protected static Select getSelect(String XPath) {
        return new Select(locate(XPath));
    }

    protected static void selectValue(String XPath, String value) {
        getSelect(XPath).selectByValue(value);
    }

    protected static void selectByText(String XPath, String text) {
        getSelect(XPath).selectByVisibleText(text);
    }

    protected static void selectIndex(String XPath, int index) {
        getSelect(XPath).selectByIndex(index);
    }

    protected static void check(String XPath) {
        if (!locate(XPath).isSelected()) {
            click(XPath);
        }
    }

    protected static void uncheck(String XPath) {
        if (locate(XPath).isSelected()) {
            click(XPath);
        }
    }

    // Wait
    protected static WebDriverWait explicitWait(int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    protected static void waitVisible(String XPath, int timeout) {
        explicitWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath)));
    }

    protected static void waitVisible(String XPath) {
        waitVisible(XPath, 5);
    }

    protected static void waitPresent(String XPath, int timeout) {
        explicitWait(timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPath)));
    }

    protected static void waitPresent(String XPath) {
        waitPresent(XPath, 5);
    }

    protected static void waitRefreshed(String XPath, int timeout) {
        explicitWait(timeout).until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(locate(XPath))));
    }

    protected static void waitRefreshed(String XPath) {
        waitRefreshed(XPath, 5);
    }

    protected static void delay(int timeout) {
        try {
            Thread.sleep(timeout * 1000L);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected static void waitInvisible(String XPath, int timeout) {
        explicitWait(timeout).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XPath)));
    }

    protected static void waitInvisible(String XPath) {
        waitInvisible(XPath, 5);
    }

    // Check
    protected static boolean isPresent(String XPath, int timeout) {
        try {
            waitPresent(XPath, timeout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected static boolean isPresent(String XPath) {
        return isPresent(XPath, 1);
    }

    protected static boolean isVisible(String XPath, int timeout) {
        try {
            waitVisible(XPath, timeout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected static boolean isVisible(String XPath) {
        return isVisible(XPath, 1);
    }

    // Executor
    protected static void clickJS(String XPath) {
        executor.executeScript("arguments[0].click();", locate(XPath));
    }

    protected static void scrollJS(String XPath) {
        executor.executeScript("arguments[0].scrollIntoView({behavior:'auto',block:'center'});", locate(XPath));
    }

    // Others
    protected static String getText(String XPath) {
        return locate(XPath).getText();
    }
}
