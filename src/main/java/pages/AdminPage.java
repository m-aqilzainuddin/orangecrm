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
    public void clickCancelButton(){
        globalCancelButton.click();
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
    @FindBy(xpath = "//button[text()[normalize-space()='Add']]")
    WebElement payGradeAddBtn;
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
        payGradeAddBtn.click();
        payGradeName.click();
        globalSaveButton.click();
    }
    public void successAddPayGrade(String pGradeName){
        payGradeAddBtn.click();
        payGradeName.click();
        payGradeName.sendKeys(pGradeName);
        globalSaveButton.click();
    }
    public void cancelAddPayGrade(String pGradeName){
        payGradeAddBtn.click();
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

    //EMPLOYEE STATUS METHODS


    //JOB CATEGORY

    //JOB CATEGORY METHODS
}
