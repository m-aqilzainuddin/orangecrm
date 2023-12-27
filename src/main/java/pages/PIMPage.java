package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {

    WebDriver driver;
    public PIMPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //GLOBAL
    @FindBy(xpath = "//span[text()[normalize-space()='PIM']]")
    WebElement pimLink;
    @FindBy(xpath = "//div[contains(@class,'orangehrm-dialog-popup')]")
    WebElement globalPopupConfirmation;
    @FindBy(xpath = "//button[text()[normalize-space()='Save']]")
    WebElement globalSaveButton;
    @FindBy(xpath = "//button[text()[normalize-space()='Cancel']]")
    WebElement globalCancelButton;
    @FindBy(xpath = "//button[text()[normalize-space()='Yes, Delete']]")
    WebElement globalConfirmDltBtn;
    @FindBy(xpath = "//button[text()[normalize-space()='No, Cancel']]")
    WebElement globalConfirmCancelBtn;
    @FindBy(xpath = "//span[text()[normalize-space()='Required']]")
    WebElement globalInputRequired;
    @FindBy(xpath = "//p[text()[normalize-space()='Successfully Saved']]")
    WebElement globalSuccessfullySaveMsg;
    @FindBy(xpath = "//p[text()[normalize-space()='Successfully Updated']]")
    WebElement globalSuccessfullyUpdateMsg;
    @FindBy(xpath = "//p[text()[normalize-space()='Successfully Deleted']]")
    WebElement globalSuccessfullyDltMsg;
    @FindBy(xpath = "//button[text()[normalize-space()='Add']]")
    WebElement globalAddBtn;
    @FindBy(xpath = "//button[text()[normalize-space()='Search']]")
    WebElement globalSearchBtn;


    //GLOBAL METHOD
    public boolean pimLinkDisplayed(){
        return pimLink.isDisplayed();
    }
    public void clickAddButton(){
        globalAddBtn.isDisplayed();
        globalAddBtn.click();
    }
    public void clickSaveBtn(){
        globalSaveButton.isDisplayed();
        globalSaveButton.click();
    }
    public void clickCancelButton(){
        globalCancelButton.isDisplayed();
        globalCancelButton.click();
    }
    public boolean verifyInputErrorMsg(){
        return globalInputRequired.isDisplayed();
    }
    public boolean verifySuccessAddMsg(){
        return globalSuccessfullySaveMsg.isDisplayed();
    }
    public boolean verifySuccessUpdateMsg(){
        return globalSuccessfullyUpdateMsg.isDisplayed();
    }
    public void verifyPopupDisplayed(){
        globalPopupConfirmation.isDisplayed();
    }
    public void clickPopupCancelButton(){
        globalConfirmCancelBtn.isDisplayed();
        globalConfirmCancelBtn.click();
    }
    public void clickPopupConfirmButton(){
        globalConfirmDltBtn.isDisplayed();
        globalConfirmDltBtn.click();
    }
    public void verifySuccessDltMsg(){
        globalSuccessfullyDltMsg.isDisplayed();
    }

    //EMPLOYEE
    //Add-Employee
    @FindBy(xpath = "//input[contains(@class,'orangehrm-firstname')]")
    WebElement empFirstName;
    @FindBy(xpath = "//input[contains(@class,'orangehrm-middlename')]")
    WebElement empMidName;
    @FindBy(xpath = " //input[contains(@class,'orangehrm-lastname')]")
    WebElement empLastName;
    @FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div/input")
    WebElement empID;
    @FindBy(xpath = "//p[text()='Create Login Details']/following::span")
    WebElement empCreateLoginToggle;
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div/input")
    WebElement empUsername;
    @FindBy(xpath = "//label[text()='Enabled']")
    WebElement empStatEnabled;
    @FindBy(xpath = "//label[text()='Disabled']")
    WebElement empStatDisabled;
    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div/input")
    WebElement empPass;
    @FindBy(xpath = "//label[text()='Confirm Password']/../following-sibling::div/input")
    WebElement empConfirmPass;

    //Search Employee Information
    @FindBy(xpath = "//label[text()='Employee Name']/../following-sibling::div//input")
    WebElement empSearchByName;
    @FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div//input")
    WebElement empSearchByID;
    @FindBy(xpath = "//label[text()='Employment Status']/../following-sibling::div")
    WebElement empSearchEmpStatus;
    @FindBy(xpath = "//label[text()='Employment Status']/../following-sibling::div//span[contains(text(),'Full-Time Permanent')]")
    WebElement empSearchSelectEmpStatus;
    @FindBy(xpath = "//div[text()[normalize-space()='Hanafi']]")
    List<WebElement> empDisplayFName;
    @FindBy(xpath = "//div[text()[normalize-space()='Hafi']]")
    List<WebElement> empDisplayLName;
    @FindBy(xpath = "//div[text()[normalize-space()='Hussein']]")
    List<WebElement> empUpdatedDisplayLName;

    //Personal-Details Employee (For-Update)
    @FindBy(xpath = "//a[text()='Personal Details']")
    WebElement empPersonalDetailsLink;
    @FindBy(xpath = "//label[text()='Nationality']/../following-sibling::div")
    WebElement empNationality;
    @FindBy(xpath = "//label[text()='Nationality']/../following-sibling::div//span[contains(text(),'Malaysian')]")
    WebElement empSelectNationality;
    @FindBy(xpath = "//label[text()='Male']")
    WebElement empGenderMale;

    //Contact-Details Employee (For-Update)
    @FindBy(xpath = "//a[text()='Contact Details']")
    WebElement empContactDetailsLink;
    @FindBy(xpath = "//label[text()='Street 1']/../following-sibling::div/input")
    WebElement empStreet;
    @FindBy(xpath = "//label[text()='City']/../following-sibling::div/input")
    WebElement empCity;
    @FindBy(xpath = "//label[text()='State/Province']/../following-sibling::div/input")
    WebElement empState;
    @FindBy(xpath = "//label[text()='Zip/Postal Code']/../following-sibling::div/input")
    WebElement empPostalCode;
    @FindBy(xpath = "//label[text()='Country']/../following-sibling::div")
    WebElement empCountry;
    @FindBy(xpath = "//label[text()='Country']/../following-sibling::div//span[contains(text(),'Malaysia')]")
    WebElement empSelectCountry;
    @FindBy(xpath = "//label[text()='Mobile']/../following-sibling::div/input")
    WebElement empMobileNum;
    @FindBy(xpath = "//label[text()='Work Email']/../following-sibling::div/input")
    WebElement empWorkEmail;

    //Job Employee (For-Update)
    @FindBy(xpath = "//div[text()[normalize-space()='Hanafi']]/../following-sibling::div//i[contains(@class,'bi-pencil-fill')]")
    WebElement empEditDetails;
    @FindBy(xpath = "//a[text()='Job']")
    WebElement empJobLink;
    @FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div")
    WebElement empJobTitle;
    @FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div//span[contains(text(),'QA Engineer')]")
    WebElement empSelectJobTitle;
    @FindBy(xpath = "//label[text()='Job Category']/../following-sibling::div")
    WebElement empJobCategory;
    @FindBy(xpath = "//label[text()='Job Category']/../following-sibling::div//span[contains(text(),'Professionals')]")
    WebElement empSelectJobCategory;
    @FindBy(xpath = "//label[text()='Sub Unit']/../following-sibling::div")
    WebElement empSubUnit;
    @FindBy(xpath = "//label[text()='Sub Unit']/../following-sibling::div//span[contains(text(),'Quality Assurance')]")
    WebElement empSelectSubUnit;
    @FindBy(xpath = "//label[text()='Location']/../following-sibling::div")
    WebElement empLocation;
    @FindBy(xpath = "//label[text()='Location']/../following-sibling::div//span[contains(text(),'HQ - CA, USA')]")
    WebElement empSelectLocation;
    @FindBy(xpath = "//label[text()='Employment Status']/../following-sibling::div")
    WebElement empEmploymentStatus;
    @FindBy(xpath = "//label[text()='Employment Status']/../following-sibling::div//span[contains(text(),'Full-Time Permanent')]")
    WebElement empSelectEmploymentStatus;

    //Employee Delete
    @FindBy(xpath = "//div[text()[normalize-space()='Hanafi']]/../following-sibling::div//i[contains(@class,'bi-trash')]")
    WebElement empDelete;


    //EMPLOYEE METHOD
    public void clickPIMLink(){
        boolean isDisplay = pimLink.isDisplayed();
        if(isDisplay){
            pimLink.click();
        }
    }
    public void failAddEmployeeWithoutLoginDetails(){
        globalAddBtn.click();
        globalSaveButton.click();
        globalInputRequired.isDisplayed();
    }
    public void failAddEmployeeWithLoginDetails(String fname,String lname,String username){
        globalAddBtn.click();
        empFirstName.sendKeys(fname);
        empLastName.sendKeys(lname);
        empCreateLoginToggle.click();
        empUsername.sendKeys(username);
        globalSaveButton.click();
        globalInputRequired.isDisplayed();
    }
    public void cancelAddEmployeeWithoutLoginDetails(String fname,String lname, String fullname){
        globalAddBtn.click();
        empFirstName.sendKeys(fname);
        empLastName.sendKeys(lname);
        globalCancelButton.click();
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.click();
    }
    public void cancelAddEmployeeWithLoginDetails(String fname,String lname,String username,String pass,String cpass,String fullname){
        globalAddBtn.click();
        empFirstName.sendKeys(fname);
        empLastName.sendKeys(lname);
        empCreateLoginToggle.click();
        empUsername.sendKeys(username);
        empPass.click();
        empPass.sendKeys(pass);
        empConfirmPass.click();
        empConfirmPass.sendKeys(cpass);
        globalCancelButton.click();
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.click();
    }
    public void successAddEmployeeWithoutLoginDetails(String fname,String lname, String fullname){
        globalAddBtn.click();
        empFirstName.sendKeys(fname);
        empLastName.sendKeys(lname);
        globalSaveButton.click();
        globalSuccessfullySaveMsg.isDisplayed();
        pimLink.isDisplayed();
        pimLink.click();
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.click();
    }
    public void successAddEmployeeWithLoginDetails(String fname,String lname,String username,String pass,String cpass,String fullname){
        globalAddBtn.click();
        empFirstName.sendKeys(fname);
        empLastName.sendKeys(lname);
        empCreateLoginToggle.click();
        empUsername.sendKeys(username);
        empPass.click();
        empPass.sendKeys(pass);
        empConfirmPass.click();
        empConfirmPass.sendKeys(cpass);
        globalSaveButton.click();
        globalSuccessfullySaveMsg.isDisplayed();
        pimLink.click();
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.click();
    }
    public void cancelUpdateEmployeeDetails(String fullname, String updatelname){
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.click();
        empEditDetails.click();
        empLastName.click();
        empLastName.sendKeys(Keys.CONTROL,"A");
        empLastName.sendKeys(Keys.DELETE);
        empLastName.sendKeys(updatelname);
        empNationality.click();
        empSelectNationality.click();
        empGenderMale.click();
    }
    public void successUpdateEmployeeDetails(String fullname, String updatelname, String empstreet, String empcity, String empstate, String empposcode, String empmobile, String empemail){
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.click();
        empEditDetails.click();
        empLastName.click();
        empLastName.sendKeys(Keys.CONTROL,"A");
        empLastName.sendKeys(Keys.DELETE);
        empLastName.sendKeys(updatelname);
        empNationality.click();
        empSelectNationality.click();
        empGenderMale.click();
        globalSaveButton.click();
        globalSuccessfullyUpdateMsg.isDisplayed();
        empContactDetailsLink.click();
        empStreet.click();
        empStreet.sendKeys(empstreet);
        empCity.click();
        empCity.sendKeys(empcity);
        empState.click();
        empState.sendKeys(empstate);
        empPostalCode.click();
        empPostalCode.sendKeys(empposcode);
        empCountry.click();
        empSelectCountry.click();
        empMobileNum.click();
        empMobileNum.sendKeys(empmobile);
        empWorkEmail.click();
        empWorkEmail.sendKeys(empemail);
        globalSaveButton.click();
        globalSuccessfullyUpdateMsg.isDisplayed();
    }
    public void successUpdateEmployeeJobDetails(String fullname){
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.click();
        empEditDetails.click();
        empJobLink.click();
        empJobTitle.click();
        empSelectJobTitle.click();
        empJobCategory.click();
        empSelectJobCategory.click();
        empSubUnit.click();
        empSelectSubUnit.click();
        empLocation.click();
        empSelectLocation.click();
        empEmploymentStatus.click();
        empSelectEmploymentStatus.click();
        globalSaveButton.click();
        globalSuccessfullyUpdateMsg.isDisplayed();
    }
    public void cancelDeleteEmployee(String fullname){
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.click();
        empDelete.click();
        globalPopupConfirmation.isDisplayed();
        globalConfirmCancelBtn.click();
    }
    public void successDeleteEmployee(String fullname){
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.click();
        empDelete.click();
        globalPopupConfirmation.isDisplayed();
        globalConfirmDltBtn.click();
        globalSuccessfullyDltMsg.isDisplayed();
    }
    public boolean verifyEmployeeExist() {
        int count = empDisplayFName.size()&empDisplayLName.size(); //if both condition met then it true. count = 1.
        return count > 0;
    }
    public boolean verifyUpdatedEmployeeDetailsExist() {
        int count = empDisplayFName.size()&empUpdatedDisplayLName.size(); //if both condition met then it true. count = 1.
        return count > 0;
    }


    //REPORT
    @FindBy(xpath = "//a[text()='Reports']")
    WebElement reportLink;
    @FindBy(xpath = "//label[text()='Report Name']/../following-sibling::div/input")
    WebElement reportName;
    @FindBy(xpath = "//label[text()='Include']/../following-sibling::div")
    WebElement reportInclude;
    @FindBy(xpath = "//label[text()='Include']/../following-sibling::div//span[contains(text(), 'Current Employees Only')]")
    WebElement reportSelectInclude;
    @FindBy(xpath = "//label[text()='Select Display Field Group']/../following-sibling::div")
    WebElement reportFirstSelection;
    @FindBy(xpath = "//label[text()='Select Display Field Group']/../following-sibling::div//span[contains(text(), 'Personal')]")
    WebElement reportSelectPersonalDisplay;
    @FindBy(xpath = "//label[text()='Select Display Field']/../following-sibling::div")
    WebElement reportSecondSelection;
    @FindBy(xpath = "//label[text()='Select Display Field']/../following-sibling::div//span[contains(text(),'Employee First Name')]")
    WebElement reportSelectEmployeeFirstName;
    @FindBy(xpath = "//label[text()='Select Display Field']/../following-sibling::div//span[contains(text(),'Employee Last Name')]")
    WebElement reportSelectEmployeeLastName;
    @FindBy(xpath = "//label[text()='Select Display Field']/../following-sibling::div//span[contains(text(),'Employee Id')]")
    WebElement reportSelectEmployeeID;
    @FindBy(xpath = "//label[text()='Select Display Field Group']/../following-sibling::div//span[contains(text(), 'Job')]")
    WebElement reportSelectJobDisplay;
    @FindBy(xpath = "//label[text()='Select Display Field']/../following-sibling::div//span[contains(text(),'Job Title')]")
    WebElement reportSelectJobTitle;
    @FindBy(xpath = "//label[text()='Select Display Field']/../following-sibling::div//span[contains(text(),'Sub Unit')]")
    WebElement reportSelectSubUnit;
    @FindBy(xpath = "//label[text()='Select Display Field']/../following-sibling::div//span[contains(text(),'Location')]")
    WebElement reportSelectLocation;
    @FindBy(xpath = "//h6[text()='Selection Criteria']/../following-sibling::div//button[contains(@class,'orangehrm-report-icon')]")
    WebElement reportSecondSelectionAddBtn;

    //REPORT-UPDATE
    @FindBy(xpath = "//div[contains(text(),'EmployeeDetails')]")
    List<WebElement> reportDisplayName;
    @FindBy(xpath = "//div[contains(text(),'Current Employee Details')]")
    List<WebElement> reportUpdatedDisplayName;
    @FindBy(xpath = "//div[contains(text(),'Employee Contact info report')]/../following-sibling::div//i[contains(@class,'bi-pencil-fill')]")
    WebElement reportEditBtn;
    @FindBy(xpath = "//span[contains(text(),'Employee Id')]/i[contains(@class,'--clear')]")
    WebElement reportClearEmpID;

    //REPORT-DELETE
    @FindBy(xpath = "//div[contains(text(),'Current Employee Details')]/../following-sibling::div//i[contains(@class,'bi-trash')]")
    WebElement reportDltBtn;

    //REPORT METHOD
    public void clickReportLink(){
        boolean isDisplay = pimLink.isDisplayed();
        if(isDisplay){
            pimLink.click();
            reportLink.click();
        }
    }
    public void cancelAddReport(String reportname){
        reportLink.click();
        globalAddBtn.click();
        reportName.click();
        reportName.sendKeys(reportname);
        reportInclude.click();
        reportSelectInclude.click();
        //firstname
        reportFirstSelection.click();
        reportSelectPersonalDisplay.click();
        reportSecondSelection.click();
        reportSelectEmployeeFirstName.click();
        reportSecondSelectionAddBtn.click();
        //lastname
        reportSecondSelection.click();
        reportSelectEmployeeLastName.click();
        reportSecondSelectionAddBtn.click();
        //click-cancel-btn
        globalCancelButton.click();
    }
    public void failAddReport(){
        reportLink.click();
        globalAddBtn.click();
        //current-employees-only
        reportInclude.click();
        reportSelectInclude.click();
        //firstname
        reportFirstSelection.click();
        reportSelectPersonalDisplay.click();
        reportSecondSelection.click();
        reportSelectEmployeeFirstName.click();
        reportSecondSelectionAddBtn.click();
        //lastname
        reportSecondSelection.click();
        reportSelectEmployeeLastName.click();
        reportSecondSelectionAddBtn.click();
        //click-save-btn
        globalSaveButton.click();
        globalInputRequired.isDisplayed();
    }
    public void successAddReport(String reportname){
        reportLink.click();
        globalAddBtn.click();
        reportName.click();
        reportName.sendKeys(reportname);
        reportInclude.click();
        reportSelectInclude.click();
        //firstname
        reportFirstSelection.click();
        reportSelectPersonalDisplay.click();
        reportSecondSelection.click();
        reportSelectEmployeeFirstName.click();
        reportSecondSelectionAddBtn.click();
        //lastname
        reportSecondSelection.click();
        reportSelectEmployeeLastName.click();
        reportSecondSelectionAddBtn.click();
        //employee-id
        reportSecondSelection.click();
        reportSelectEmployeeID.click();
        reportSecondSelectionAddBtn.click();
        //job-title
        reportFirstSelection.click();
        reportSelectJobDisplay.click();
        reportSecondSelection.click();
        reportSelectJobTitle.click();
        reportSecondSelectionAddBtn.click();
        //job(sub-unit)
        reportSecondSelection.click();
        reportSelectSubUnit.click();
        reportSecondSelectionAddBtn.click();
        //job(location)
        reportSecondSelection.click();
        reportSelectLocation.click();
        reportSecondSelectionAddBtn.click();
        //click-save-btn
        globalSaveButton.click();
        globalSuccessfullySaveMsg.isDisplayed();
    }
    public void cancelUpdateReport(String reportname){
        reportEditBtn.click();
        reportName.click();
        reportName.sendKeys(Keys.CONTROL,"A");
        reportName.sendKeys(Keys.DELETE);
        reportName.sendKeys(reportname);
        reportClearEmpID.click();
        globalCancelButton.click();
    }
    public void successUpdateReport(String reportname){
        reportEditBtn.click();
        reportName.click();
        reportName.sendKeys(Keys.CONTROL,"A");
        reportName.sendKeys(Keys.DELETE);
        reportName.sendKeys(reportname);
        reportClearEmpID.click();
        globalSaveButton.click();
        globalSuccessfullyUpdateMsg.isDisplayed();
    }
    public void cancelDeleteReport(){
        reportDltBtn.click();
        globalPopupConfirmation.isDisplayed();
        globalConfirmCancelBtn.click();
    }
    public void successDeleteReport(){
        reportDltBtn.click();
        globalPopupConfirmation.isDisplayed();
        globalConfirmDltBtn.click();
        globalSuccessfullyDltMsg.isDisplayed();
    }
    public boolean verifyReportExist() {
        int count = reportDisplayName.size();
        return count > 0;
    }
    public boolean verifyUpdatedReportExist() {
        int count = reportUpdatedDisplayName.size();
        return count > 0;
    }

}
