package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    public static void initialization(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
