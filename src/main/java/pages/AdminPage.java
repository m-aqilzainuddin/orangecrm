package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {

    WebDriver driver;
    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //GLOBAL
    @FindBy(xpath = "//a[contains(@href, 'viewAdminModule')]")
    WebElement adminLink;
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

    //GLOBAL METHODS
    public boolean adminLinkDisplayed(){
        return adminLink.isDisplayed();
    }
    public boolean verifySuccessAddMsg(){
        return globalSuccessfullySaveMsg.isDisplayed();
    }
    public boolean verifySuccessfullyUpdate(){
        return globalSuccessfullyUpdateMsg.isDisplayed();
    }
    public void clickSaveBtn(){
        globalSaveButton.click();
    }
    public void clickCancelButton(){
        globalCancelButton.click();
    }
    public boolean errorDisplayed(){
        return globalInputRequired.isDisplayed();
    }

    //SYSTEM USERS
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div/input")
    WebElement adminUsername;

    @FindBy(xpath = "//div[text()='Admin']")
    WebElement adminUsernameResult;

    @FindBy (xpath = "//p[text()='No Records Found']")
    WebElement adminErrorUsername;

    @FindBy(xpath = "//button[text()[normalize-space()='Search']]")
    WebElement adminSearchButton;

    @FindBy(xpath = "//button[text()[normalize-space()='Reset']]")
    WebElement adminResetButton;

    //SYSTEM USERS METHODS
    public void enterSystemUsername(String username){
        adminUsername.click();
        adminUsername.sendKeys(username);
    }
    public void clickSearchButton(){
        adminSearchButton.click();
    }
    public void clickResetButton(){
        adminResetButton.click();
    }

    public boolean usernameDisplayed(){
        return adminUsernameResult.isDisplayed();
    }
    public boolean usernameNotDisplayed(){
        return adminErrorUsername.isDisplayed();
    }

    //JOB TITLE
    @FindBy(xpath = "//span[text()[normalize-space()='Job']]")
    WebElement jobLink;
    @FindBy(xpath = "//a[text()[normalize-space()='Job Titles']]")
    WebElement jobTitleLink;
    @FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div/input")
    WebElement jobTitleName;
    @FindBy(xpath = "//label[text()='Job Description']/../following-sibling::div/textarea")
    WebElement jobTitleDesc;
    @FindBy(xpath = "//span[text()='Show More']")
    WebElement jobTitleDescMore;
    @FindBy(xpath = "//div[text()='Quality Assurance']/../following-sibling::div//span[text()=\"Responsible for monitoring and improve an organization's final products.\"]")
    WebElement jobTitleDescDisplayed;
    @FindBy(xpath = "//div[text()[normalize-space()='Quality Assurance']]")
    List<WebElement> jobTitleDisplayed;
    @FindBy(xpath = "//div[text()[normalize-space()='Quality Assurance']]/../following-sibling::div//i[contains(@class,'bi-pencil-fill')]")
    WebElement jobTitleEditBtn;
    @FindBy(xpath = "//div[text()[normalize-space()='Quality Assurance']]/../following-sibling::div//i[contains(@class,'bi-trash')]")
    WebElement jobTitleDltBtn;

    //JOB TITLE METHODS
    public void clickJobTitle(){
        boolean isDisplay = adminLink.isDisplayed();
        if(isDisplay){
            adminLink.click();
        }
        jobLink.click();
        jobTitleLink.click();
    }
    public void inputJobDescInput(String jobDesc){
        jobTitleDesc.click();
        jobTitleDesc.sendKeys(jobDesc);
    }
    public void clickJobTitleDescMoreBtn(){
        jobTitleDescMore.click();
    }
    public boolean checkJobDescDisplayed(){
        return jobTitleDescDisplayed.isDisplayed();
    }
    public void clearInputJobTitle() throws InterruptedException{
        jobTitleName.click();
        jobTitleName.sendKeys(Keys.CONTROL,"A");
        jobTitleName.sendKeys(Keys.DELETE);
    }
    public void addJobTitle(){
        globalAddBtn.click();
    }
    public boolean verifyJobTitleExistance(){
        int count = jobTitleDisplayed.size();
        return count > 0;
    }
    public void inputJobTitle(String jobTitle){
        jobTitleName.click();
        jobTitleName.sendKeys(jobTitle);
    }
    public void editJobDesc(String jobDesc){
        boolean isExist = jobTitleEditBtn.isDisplayed();
        if(isExist) {
            jobTitleEditBtn.click();
            jobTitleDesc.click();
            jobTitleDesc.sendKeys(jobDesc);
        }
    }
    public void clearEditJobDesc(String jobDesc){
        boolean isExist = jobTitleEditBtn.isDisplayed();
        if(isExist) {
            jobTitleEditBtn.click();
            jobTitleDesc.click();
            jobTitleDesc.sendKeys(Keys.CONTROL,"A");
            jobTitleDesc.sendKeys(Keys.DELETE);
            jobTitleDesc.sendKeys(jobDesc);
        }
    }
    public void dltJobTitle(){
        boolean isExist = jobTitleDltBtn.isDisplayed();
        if(isExist) {
            jobTitleDltBtn.click();
        }
        boolean isDisplay = globalPopupConfirmation.isDisplayed();
        if(isDisplay){
            globalConfirmDltBtn.click();
        }
    }
    public void cancelDltJobTitle(){
        boolean isExist = jobTitleDltBtn.isDisplayed();
        if(isExist) {
            jobTitleDltBtn.click();
        }
        boolean isDisplay = globalPopupConfirmation.isDisplayed();
        if(isDisplay){
            globalConfirmCancelBtn.click();
        }
    }

    //PAY GRADE
    @FindBy(xpath = "//a[text()='Pay Grades']")
    WebElement payGradeLink;
    @FindBy(xpath = "//label[text()[normalize-space()='Name']]/../following-sibling::div/input")
    WebElement payGradeName;
    @FindBy(xpath = "//div[text()[normalize-space()='Grade 40']]/../following-sibling::div//i[contains(@class,'bi-trash')]")
    WebElement payGradeDltRecord;
    @FindBy(xpath = "//div[text()[normalize-space()='Grade 40']]/../following-sibling::div//i[contains(@class,'bi-pencil-fill')]")
    WebElement payGradeEditRecord;
    @FindBy(xpath = "//label[text()[normalize-space()='Currency']]/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
    WebElement payGradeCurrency;
    @FindBy(xpath = "//h6[text()[normalize-space()='Add Currency']]/following::button[text()[normalize-space()='Save']]")
    WebElement payGradeCurrSaveBtn;
    @FindBy(xpath = "//h6[text()[normalize-space()='Add Currency']]/following::button[text()[normalize-space()='Cancel']]")
    WebElement payGradeCurrCancelBtn;
    @FindBy(xpath = "//div[@role='listbox']/div/span[text()='MYR - Malaysian Ringgit']")
    WebElement payGradeCurrMYR;
    @FindBy(xpath = "//label[text()[normalize-space()='Minimum Salary']]/../following-sibling::div/input")
    WebElement payGradeMinSalary;
    @FindBy(xpath = "//label[text()[normalize-space()='Maximum Salary']]/../following-sibling::div/input")
    WebElement payGradeMaxSalary;
    @FindBy(xpath = "//div[text()[normalize-space()='Malaysian Ringgit']]")
    List<WebElement> payGradeRecordDisplay;
    @FindBy(xpath = "//div[text()[normalize-space()='Grade 40']]")
    List<WebElement> payGradeDisplayed;

    //PAY GRADE METHODS
    public void clickPayGrade(){
        boolean isExist = adminLink.isDisplayed();
        if(isExist) {
            adminLink.click();
            jobLink.click();
            payGradeLink.click();
        }
    }
    public void failAddPayGrade(){
        globalAddBtn.click();
        payGradeName.click();
        globalSaveButton.click();
    }
    public void successAddPayGrade(String pGradeName){
        globalAddBtn.click();
        payGradeName.click();
        payGradeName.sendKeys(pGradeName);
        globalSaveButton.click();
    }
    public void cancelAddPayGrade(String pGradeName){
        globalAddBtn.click();
        payGradeName.click();
        payGradeName.sendKeys(pGradeName);
        globalCancelButton.click();
    }
    public void failUpdatePayGrade(){
        payGradeEditRecord.click();
        globalAddBtn.click();
        payGradeMinSalary.sendKeys("1");
        payGradeMaxSalary.sendKeys("1000000");
        payGradeCurrSaveBtn.click();
        globalInputRequired.isDisplayed();
    }
    public void successUpdatePayGrade(){
        payGradeEditRecord.click();
        globalAddBtn.click();
        payGradeCurrency.click();
        payGradeCurrMYR.click();
        payGradeMinSalary.sendKeys("1");
        payGradeMaxSalary.sendKeys("1000000");
        payGradeCurrSaveBtn.click();
        globalSuccessfullyUpdateMsg.isDisplayed();
    }
    public void cancelUpdatePayGrade(){
        payGradeEditRecord.click();
        globalAddBtn.click();
        payGradeCurrency.click();
        payGradeCurrMYR.click();
        payGradeMinSalary.sendKeys("1");
        payGradeMaxSalary.sendKeys("1000000");
        payGradeCurrCancelBtn.click();
    }
    public void cancelDltPayGrade(){
        payGradeDltRecord.click();
        globalPopupConfirmation.isDisplayed();
        globalConfirmCancelBtn.click();
    }
    public void successDltPayGrade(){
        payGradeDltRecord.click();
        globalPopupConfirmation.isDisplayed();
        globalConfirmDltBtn.click();
        globalSuccessfullyDltMsg.isDisplayed();
    }
    public boolean verifyPayGradeRecordExist(){
        int count = payGradeRecordDisplay.size();
        return count > 0;
    }
    public boolean verifyPayGradeExist(){
        int count = payGradeDisplayed.size();
        return count > 0;
    }

    //EMPLOYEE STATUS
    @FindBy(xpath = "//a[text()[normalize-space()='Employment Status']]")
    WebElement employmentLink;
    @FindBy(xpath = "//label[text()[normalize-space()='Name']]/following::input")
    WebElement employmentStatusName;
    @FindBy(xpath = "//div[text()[normalize-space()='Full-Time Employee']]/../following-sibling::div//i[contains(@class,'bi-pencil-fill')]")
    WebElement employmentEditStatus;
    @FindBy(xpath = "//div[text()[normalize-space()='Full-Time Emp']]/../following-sibling::div//i[contains(@class,'bi-trash')]")
    WebElement employmentDltStatus;
    @FindBy(xpath = "//div[text()[normalize-space()='Full-Time Employee']]")
    List<WebElement> employmentStatusDisplayed;
    @FindBy(xpath = "//div[text()[normalize-space()='Full-Time Emp']]")
    List<WebElement> employmentStatusUpdated;



    //EMPLOYEE STATUS METHODS
    public void clickEmploymentStatus(){
        boolean isExist = adminLink.isDisplayed();
        if(isExist) {
            adminLink.click();
            jobLink.click();
            employmentLink.click();
        }
    }
    public void cancelAddEmpStatus(String EmpStatus){
        globalAddBtn.click();
        employmentStatusName.sendKeys(EmpStatus);
        globalCancelButton.click();
    }
    public void failAddEmpStatus(){
        globalAddBtn.click();
        globalSaveButton.click();
        globalInputRequired.isDisplayed();
    }
    public void successAddEmpStatus(String empStatus){
        globalAddBtn.click();
        employmentStatusName.sendKeys(empStatus);
        globalSaveButton.click();
        globalSuccessfullySaveMsg.isDisplayed();
    }
    public void cancelUpdateEmpStatus(String empStatus){
        employmentEditStatus.click();
        employmentStatusName.click();
        employmentStatusName.sendKeys(Keys.CONTROL,"A");
        employmentStatusName.sendKeys(Keys.DELETE);
        employmentStatusName.sendKeys(empStatus);
        globalCancelButton.click();
    }
    public void failUpdateEmpStatus(){
        employmentEditStatus.click();
        employmentStatusName.click();
        employmentStatusName.sendKeys(Keys.CONTROL,"A");
        employmentStatusName.sendKeys(Keys.DELETE);
        globalSaveButton.click();
        globalInputRequired.isDisplayed();
    }
    public void successUpdateEmpStatus(String empStatus){
        employmentEditStatus.click();
        employmentStatusName.click();
        employmentStatusName.sendKeys(Keys.CONTROL,"A");
        employmentStatusName.sendKeys(Keys.DELETE);
        employmentStatusName.sendKeys(empStatus);
        globalSaveButton.click();
    }
    public void cancelDltEmpStatus(){
        employmentDltStatus.click();
        globalPopupConfirmation.isDisplayed();
        globalConfirmCancelBtn.click();
    }
    public void successDltEmpStatus(){
        employmentDltStatus.click();
        globalPopupConfirmation.isDisplayed();
        globalConfirmDltBtn.click();
        globalSuccessfullyDltMsg.isDisplayed();
    }
    public boolean verifyEmploymentStatusExist(){
        int count = employmentStatusDisplayed.size();
        return count > 0;
    }
    public boolean verifyUpdatedEmpStatusExist(){
        int count = employmentStatusUpdated.size();
        return count > 0;
    }


    //JOB CATEGORY
    @FindBy(xpath = "//a[text()[normalize-space()='Job Categories']]")
    WebElement jobCategoriesLink;
    @FindBy(xpath = "//label[text()[normalize-space()='Name']]/following::input")
    WebElement jobCategoriesName;
    @FindBy(xpath = "//div[text()[normalize-space()='Programmer']]/../following-sibling::div//i[contains(@class,'bi-pencil-fill')]")
    WebElement editJobCategories;
    @FindBy(xpath = "//div[text()[normalize-space()='Senior Programmer']]/../following-sibling::div//i[contains(@class,'bi-trash')]")
    WebElement dltJobCategories;
    @FindBy(xpath = "//div[text()[normalize-space()='Programmer']]")
    List<WebElement> jobCategoriesDisplayed;
    @FindBy(xpath = "//div[text()[normalize-space()='Senior Programmer']]")
    List<WebElement> jobCategoriesUpdated;

    //JOB CATEGORY METHODS
    public void clickJobCategoriesLink(){
        boolean isExist = adminLink.isDisplayed();
        if(isExist) {
            adminLink.click();
            jobLink.click();
            jobCategoriesLink.click();
        }
    }
    public void cancelAddJobCategories(String jobCategory){
        globalAddBtn.click();
        jobCategoriesName.sendKeys(jobCategory);
        globalCancelButton.click();
    }
    public void failAddJobCategories(){
        globalAddBtn.click();
        globalSaveButton.click();
        globalInputRequired.isDisplayed();
    }
    public void successAddJobCategories(String jobCategories){
        globalAddBtn.click();
        jobCategoriesName.sendKeys(jobCategories);
        globalSaveButton.click();
        globalSuccessfullySaveMsg.isDisplayed();
    }
    public void cancelUpdateJobCategories(String jobCategories){
        editJobCategories.click();
        jobCategoriesName.click();
        jobCategoriesName.sendKeys(Keys.CONTROL,"A");
        jobCategoriesName.sendKeys(Keys.DELETE);
        jobCategoriesName.sendKeys(jobCategories);
        globalCancelButton.click();
    }
    public void failUpdateJobCategories(){
        editJobCategories.click();
        jobCategoriesName.click();
        jobCategoriesName.sendKeys(Keys.CONTROL,"A");
        jobCategoriesName.sendKeys(Keys.DELETE);
        globalSaveButton.click();
        globalInputRequired.isDisplayed();
    }
    public void successUpdateJobCategories(String jobCategories){
        editJobCategories.click();
        jobCategoriesName.click();
        jobCategoriesName.sendKeys(Keys.CONTROL,"A");
        jobCategoriesName.sendKeys(Keys.DELETE);
        jobCategoriesName.sendKeys(jobCategories);
        globalSaveButton.click();
        globalSuccessfullyUpdateMsg.isDisplayed();
    }
    public void cancelDltJobCategories(){
        dltJobCategories.click();
        globalPopupConfirmation.isDisplayed();
        globalConfirmCancelBtn.click();
    }
    public void successDltJobCategories(){
        dltJobCategories.click();
        globalPopupConfirmation.isDisplayed();
        globalConfirmDltBtn.click();
        globalSuccessfullyDltMsg.isDisplayed();
    }
    public boolean verifyJobCategoriesExist(){
        int count = jobCategoriesDisplayed.size();
        return count > 0;
    }
    public boolean verifyUpdatedJobCategoriesExist(){
        int count = jobCategoriesUpdated.size();
        return count > 0;
    }
}
