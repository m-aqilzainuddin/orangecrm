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

    //unable to add new job title "form incomplete"
    @Test
    public void failAddJobTitle(){
        boolean displayAdminLink = adminPage.checkAdminLink();
        assertTrue(displayAdminLink);
        adminPage.clickAdminLink();
        adminPage.clickJobBtn();
        adminPage.clickJobTitleLink();
        adminPage.clickJobTitleAddBtn();
        adminPage.inputJobDescInput("Responsible for monitoring and improve an organization's final products.");
        adminPage.clickSaveBtn();
        boolean jobTitleError = adminPage.errorDisplayed();
        assertTrue(jobTitleError);
    }
    @Test
    public void successfulAddJobTitle(){
        boolean displayAdminLink = adminPage.checkAdminLink();
        assertTrue(displayAdminLink);
        adminPage.clickAdminLink();
        adminPage.clickJobBtn();
        adminPage.clickJobTitleLink();
        adminPage.clickJobTitleAddBtn();
        adminPage.inputJobTitle("Quality Assurance");
        adminPage.clickSaveBtn();
        boolean successfullyAddedMsg = adminPage.verifySuccessAddMsg();
        assertTrue(successfullyAddedMsg);
        adminPage.clickJobBtn();
        adminPage.clickJobTitleLink();
        boolean verifyJobTitleDisplayed = adminPage.verifyJobTitleExistance();
        assertTrue(verifyJobTitleDisplayed);
    }
    @Test
    public void cancelAddJobTitle(){
        boolean displayAdminLink = adminPage.checkAdminLink();
        assertTrue(displayAdminLink);
        adminPage.clickAdminLink();
        adminPage.clickJobBtn();
        adminPage.clickJobTitleLink();
        adminPage.clickJobTitleAddBtn();
        adminPage.inputJobTitle("Quality Assurance");
        adminPage.clickCancelButton();
        adminPage.clickJobBtn();
        adminPage.clickJobTitleLink();
        boolean verifyJobTitleDisplayed = adminPage.verifyJobTitleExistance();
        assertFalse(verifyJobTitleDisplayed);
    }
    @Test
    public void failEditJobTitle() throws InterruptedException {
        boolean displayAdminLink = adminPage.checkAdminLink();
        assertTrue(displayAdminLink);
        adminPage.clickAdminLink();
        adminPage.clickJobBtn();
        adminPage.clickJobTitleLink();
        boolean verifyJobTitleDisplayed = adminPage.verifyJobTitleExistance();
        assertTrue(verifyJobTitleDisplayed);
        adminPage.clickEditJobTitleBtn();
        //adminPage.inputJobDescInput("Responsible for monitoring and improve an organization's final products.");
        adminPage.clearInputJobTitle();
        adminPage.clickSaveBtn();
        adminPage.errorDisplayed();
    }
    @Test
    public void successfulEditJobTitle() throws InterruptedException {
        boolean displayAdminLink = adminPage.checkAdminLink();
        assertTrue(displayAdminLink);
        adminPage.clickAdminLink();
        adminPage.clickJobBtn();
        adminPage.clickJobTitleLink();
        boolean verifyJobTitleDisplayed = adminPage.verifyJobTitleExistance();
        assertTrue(verifyJobTitleDisplayed);
        adminPage.clickEditJobTitleBtn();
        adminPage.inputJobDescInput("Responsible for monitoring and improve an organization's final products.");
        adminPage.clickSaveBtn();
        boolean successfullyEditMsg = adminPage.verifySuccessfullyUpdate();
        assertTrue(successfullyEditMsg);
    }


}
