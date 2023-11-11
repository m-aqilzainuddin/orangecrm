import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.AdminPage;

import static config.DriverHolder.getDriver;
import static org.junit.jupiter.api.Assertions.*;

public class AdminTest extends BaseTest {
    AdminPage adminPage= new AdminPage(getDriver());
    LoginPage loginPage = new LoginPage(getDriver());
    public AdminTest(){
        super();
    }

    @BeforeEach
    public void init() throws InterruptedException {
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.enterLoginCreds("Admin","admin123");
        loginPage.clickLoginButton();
    }

    @AfterEach
    public void tearDown(){
        loginPage.logout();
    }
    @Test
    public void searchCorrectSystemUsers(){
        boolean displayAdminLink = adminPage.checkAdminLink();
        assertTrue(displayAdminLink);
        adminPage.clickAdminLink();
        adminPage.enterSystemUsername("Admin");
        adminPage.clickSearchButton();
        boolean usernameDisplayed = adminPage.usernameDisplayed();
        assertEquals(true,usernameDisplayed,"Result are not matched!");
    }
    @Test
    public void searchIncorrectSystemUsers(){
        boolean displayAdminLink = adminPage.checkAdminLink();
        assertTrue(displayAdminLink);
        adminPage.clickAdminLink();
        adminPage.enterSystemUsername("Admin1234");
        adminPage.clickSearchButton();
        boolean usernameNotExist = adminPage.usernameNotDisplayed();
        assertTrue(usernameNotExist);
    }
    @Test
    public void cancelCorrectSystemUsers(){
        boolean displayAdminLink = adminPage.checkAdminLink();
        assertTrue(displayAdminLink);
        adminPage.clickAdminLink();
        adminPage.enterSystemUsername("Admin");
        adminPage.clickResetButton();
        boolean usernameDisplayed = adminPage.usernameDisplayed();
        assertTrue(usernameDisplayed);
    }
}
