import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.PIMPage;

import static config.DriverHolder.getDriver;
import static org.junit.jupiter.api.Assertions.*;


public class PIMTest extends BaseTest{
    PIMPage pimPage= new PIMPage(getDriver());
    LoginPage loginPage = new LoginPage(getDriver());
    public PIMTest(){
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

    //EMPLOYEE LIST
    @Test
    public void failAddEmployeeWithoutLoginDetails(){
        pimPage.clickPIMLink();
        pimPage.failAddEmployeeWithoutLoginDetails();
    }
    @Test
    public void failAddEmployeeWithLoginDetails(){
        pimPage.clickPIMLink();
        pimPage.failAddEmployeeWithLoginDetails("Hanafi","Hafi","Hafi26");
    }
    @Test
    public void cancelAddEmployeeWithoutLoginDetails(){
        pimPage.clickPIMLink();
        pimPage.cancelAddEmployeeWithoutLoginDetails("Hanafi","Hafi","Hanafi Hafi");
        boolean verifyEmpExist = pimPage.verifyEmployeeExist();
        assertFalse(verifyEmpExist);
    }
    @Test
    public void cancelAddEmployeeWithLoginDetails(){
        pimPage.clickPIMLink();
        pimPage.cancelAddEmployeeWithLoginDetails("Hanafi","Hafi","Hafi26","Abcd1234","Abcd1234","Hanafi Hafi");
        boolean verifyEmpExist = pimPage.verifyEmployeeExist();
        assertFalse(verifyEmpExist);
    }
    @Test
    public void successAddEmployeeWithoutLoginDetails(){
        pimPage.clickPIMLink();
        pimPage.successAddEmployeeWithoutLoginDetails("Hanafi","Hafi","Hanafi Hafi");
        boolean verifyEmpExist = pimPage.verifyEmployeeExist();
        assertTrue(verifyEmpExist);
    }
    @Test
    public void successAddEmployeeWithLoginDetails(){
        pimPage.clickPIMLink();
        pimPage.successAddEmployeeWithLoginDetails("Hanafi","Hafi","Hafi26","Abcd1234","Abcd1234","Hanafi Hafi");
        boolean verifyEmpExist = pimPage.verifyEmployeeExist();
        assertTrue(verifyEmpExist);
    }

}

