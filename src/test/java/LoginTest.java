import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.TestBase;
import pages.LoginPage;
import pages.AdminPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static config.DriverHolder.getDriver;
import static org.junit.jupiter.api.Assertions.*;


public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage(getDriver());
    AdminPage adminPage = new AdminPage(getDriver());

    @BeforeEach
    public void init() {
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void loginCorrectUserCorrectPass() throws InterruptedException {
        loginPage.enterLoginCreds("Admin","admin123");
        loginPage.clickLoginButton();
        boolean verifyAdminLink = adminPage.checkAdminLink();
        assertTrue(verifyAdminLink);
    }

    @Test
    public void loginCorrectUserIncorrectPass() throws InterruptedException {
        loginPage.enterLoginCreds("Admin","admin12345");
        loginPage.clickLoginButton();
        boolean errorDisplayed = loginPage.errorMsgDisplayed();
        assertTrue(errorDisplayed);
//        assertEquals(true,errorDisplayed,"Result are not matched!");
    }

    @Test
    public void loginIncorrectUserCorrectPass() throws InterruptedException {
        loginPage.enterLoginCreds("Admin123","admin123");
        loginPage.clickLoginButton();
        String errorDisplayed = loginPage.errorMsgDisplayed2();
        assertEquals("Invalid credentials",errorDisplayed,"Result are not matched!");
    }


}

