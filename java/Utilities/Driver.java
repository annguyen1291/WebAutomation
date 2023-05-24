package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--window-size=1920,1080"));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getUrl() {
        return driver.getCurrentUrl();
    }

    public static void setUrl(String url) {
        driver.get(url);
    }

    public static WebDriver driver = getDriver();
}
