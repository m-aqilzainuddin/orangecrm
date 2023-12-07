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
        adminPage.clickAdmin();
        adminPage.enterSystemUsername("Admin");
        adminPage.clickSearchButton();
        boolean usernameDisplayed = adminPage.usernameDisplayed();
        assertEquals(true,usernameDisplayed,"Result are not matched!");
    }
    @Test
    public void searchIncorrectSystemUsers(){
        adminPage.clickAdmin();
        adminPage.enterSystemUsername("Admin1234");
        adminPage.clickSearchButton();
        boolean usernameNotExist = adminPage.usernameNotDisplayed();
        assertTrue(usernameNotExist);
    }
    @Test
    public void cancelCorrectSystemUsers(){
        adminPage.clickAdmin();
        adminPage.clickAdmin();
        adminPage.enterSystemUsername("Admin");
        adminPage.clickResetButton();
        boolean usernameDisplayed = adminPage.usernameDisplayed();
        assertTrue(usernameDisplayed);
    }

    //
    @Test
    public void failAddJobTitle(){
        adminPage.clickJobTitle();
        adminPage.addJobTitle();
        adminPage.inputJobDescInput("Responsible for monitoring and improve an organization's final products.");
        adminPage.clickSaveBtn();
        boolean jobTitleError = adminPage.errorDisplayed();
        assertTrue(jobTitleError);
    }
    @Test
    public void successfulAddJobTitle(){
        adminPage.clickJobTitle();
        adminPage.addJobTitle();
        adminPage.inputJobTitle("Quality Assurance");
        adminPage.clickSaveBtn();
        boolean successfullyAddedMsg = adminPage.verifySuccessAddMsg();
        assertTrue(successfullyAddedMsg);
        adminPage.clickJobTitle();
        boolean verifyJobTitleDisplayed = adminPage.verifyJobTitleExistance();
        assertTrue(verifyJobTitleDisplayed);
    }
    @Test
    public void cancelAddJobTitle(){
        adminPage.clickJobTitle();
        adminPage.addJobTitle();
        adminPage.inputJobTitle("Quality Assurance");
        adminPage.clickCancelButton();
        adminPage.clickJobTitle();
        boolean verifyJobTitleDisplayed = adminPage.verifyJobTitleExistance();
        assertFalse(verifyJobTitleDisplayed);
    }
    @Test
    public void failEditJobDesc() throws InterruptedException {
        adminPage.clickJobTitle();
        adminPage.editJobDesc("Responsible for monitoring and improve an organization's final products.");
        adminPage.clearInputJobTitle();
        adminPage.clickSaveBtn();
        adminPage.errorDisplayed();
    }
    @Test
    public void successfulEditJobDesc(){
        adminPage.clickJobTitle();
        adminPage.editJobDesc("Responsible for monitoring and improve an organization's final products.");
        adminPage.clickSaveBtn();
        boolean successfullyEditMsg = adminPage.verifySuccessfullyUpdate();
        assertTrue(successfullyEditMsg);
        adminPage.clickJobTitleDescMoreBtn();
        boolean verifyJobDescUpdated = adminPage.checkJobDescDisplayed();
        assertTrue(verifyJobDescUpdated);
    }
    @Test
    public void cancelEditJobTitleDecs(){
        adminPage.clickJobTitle();
        adminPage.clearEditJobDesc("Supervise");
        adminPage.clickCancelButton();
        adminPage.clickJobTitleDescMoreBtn();
        boolean verifyJobDescUpdated = adminPage.checkJobDescDisplayed();
        assertTrue(verifyJobDescUpdated);
    }
    @Test
    public void cancelDeleteJobTitle(){
        adminPage.clickJobTitle();
        adminPage.cancelDltJobTitle();
        adminPage.clickJobTitle();
        boolean verifyJobTitleExist = adminPage.verifyJobTitleExistance();
        assertTrue(verifyJobTitleExist);
    }
    @Test
    public void successDeleteJobTitle(){
        adminPage.clickJobTitle();
        adminPage.dltJobTitle();
        adminPage.clickJobTitle();
        boolean verifyJobTitleExist = adminPage.verifyJobTitleExistance();
        assertFalse(verifyJobTitleExist);
    }
}
