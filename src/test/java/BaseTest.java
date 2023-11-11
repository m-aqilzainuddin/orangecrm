import config.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static config.DriverHolder.getDriver;
import static config.DriverHolder.setDriver;
import static java.lang.System.getProperty;

public class BaseTest {
    @BeforeAll
    public static void before() {
        setDriver(DriverFactory.getNewDriverInstance("chrome"));
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void after() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
