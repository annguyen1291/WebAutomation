package TestRunners;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static Utilities.Driver.driver;
import static Utilities.Driver.setDriver;

@Suite
@IncludeEngines("cucumber")
public class BaseTestRunner {
    @BeforeAll
    public static void beforeAll() {
        setDriver();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }
}
