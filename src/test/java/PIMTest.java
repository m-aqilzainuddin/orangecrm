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
    @Test
    public void cancelUpdateEmployeeDetails(){
        pimPage.clickPIMLink();
        pimPage.cancelUpdateEmployeeDetails("Hanafi Hafi","Hussein");
        pimPage.clickPIMLink();
        boolean verifyUpdatedEmpExist = pimPage.verifyUpdatedEmployeeDetailsExist();
        assertFalse(verifyUpdatedEmpExist);
    }
    @Test
    public void successUpdateEmployeeDetails(){
        pimPage.clickPIMLink();
        pimPage.successUpdateEmployeeDetails("Hanafi Hafi","Hussein","Jalan Bulan","Kuala Lumpur","Selangor","50050","011-22445562","hanafihafi@hrmdemolive.com");
        pimPage.clickPIMLink();
        boolean verifyUpdatedEmpExist = pimPage.verifyUpdatedEmployeeDetailsExist();
        assertTrue(verifyUpdatedEmpExist);
    }
    @Test
    public void successUpdateEmployeeJobDetails(){
        pimPage.clickPIMLink();
        pimPage.successUpdateEmployeeJobDetails("Hanafi Hussein");
        pimPage.clickPIMLink();
        boolean verifyUpdatedEmpExist = pimPage.verifyUpdatedEmployeeDetailsExist();
        assertTrue(verifyUpdatedEmpExist);
    }
    @Test
    public void cancelDeleteEmployee(){
        pimPage.clickPIMLink();
        pimPage.cancelDeleteEmployee("Hanafi Hussein");
        pimPage.clickPIMLink();
        boolean verifyUpdatedEmpExist = pimPage.verifyUpdatedEmployeeDetailsExist();
        assertTrue(verifyUpdatedEmpExist);
    }
    @Test
    public void successDeleteEmployee(){
        pimPage.clickPIMLink();
        pimPage.successDeleteEmployee("Hanafi Hussein");
        pimPage.clickPIMLink();
        boolean verifyUpdatedEmpExist = pimPage.verifyUpdatedEmployeeDetailsExist();
        assertFalse(verifyUpdatedEmpExist);
    }
    @Test
    public void cancelAddReport(){
        pimPage.clickReportLink();
        pimPage.cancelAddReport("EmployeeDetails");
        pimPage.clickReportLink();
        boolean verifyReportExist = pimPage.verifyReportExist();
        assertFalse(verifyReportExist);
    }
    @Test
    public void failAddReport(){
        pimPage.clickReportLink();
        pimPage.failAddReport();
        pimPage.clickReportLink();
        boolean verifyReportExist = pimPage.verifyReportExist();
        assertFalse(verifyReportExist);
    }
    @Test
    public void successAddReport(){
        pimPage.clickReportLink();
        pimPage.successAddReport("EmployeeDetails");
        pimPage.clickReportLink();
        boolean verifyReportExist = pimPage.verifyReportExist();
        assertTrue(verifyReportExist);
    }
    @Test
    public void cancelUpdateReport(){
        pimPage.clickReportLink();
        boolean verifyReportExist = pimPage.verifyReportExist();
        assertTrue(verifyReportExist);
        pimPage.cancelUpdateReport("Current Employee Details");
        pimPage.clickReportLink();
        boolean verifyUpdatedReportExist = pimPage.verifyUpdatedReportExist();
        assertFalse(verifyUpdatedReportExist);

    }
    @Test
    public void successUpdateReport(){
        pimPage.clickReportLink();
        boolean verifyReportExist = pimPage.verifyReportExist();
        assertTrue(verifyReportExist);
        pimPage.successUpdateReport("Current Employee Details");
        pimPage.clickReportLink();
        boolean verifyUpdatedReportExist = pimPage.verifyUpdatedReportExist();
        assertTrue(verifyUpdatedReportExist);
    }
    @Test
    public void cancelDeleteReport(){
        pimPage.clickReportLink();
        boolean verifyUpdatedReportDisplay = pimPage.verifyUpdatedReportExist();
        assertTrue(verifyUpdatedReportDisplay);
        pimPage.cancelDeleteReport();
        boolean verifyUpdatedReportExist = pimPage.verifyUpdatedReportExist();
        assertTrue(verifyUpdatedReportExist);
    }
    @Test
    public void successDeleteReport(){
        pimPage.clickReportLink();
        boolean verifyUpdatedReportDisplay = pimPage.verifyUpdatedReportExist();
        assertTrue(verifyUpdatedReportDisplay);
        pimPage.successDeleteReport();
        boolean verifyUpdatedReportExist = pimPage.verifyUpdatedReportExist();
        assertFalse(verifyUpdatedReportExist);
    }

}

