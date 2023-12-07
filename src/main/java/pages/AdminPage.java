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

    @FindBy(xpath = "//a[contains(@href, 'viewAdminModule')]")
    WebElement adminLink;

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


    @FindBy(xpath = "//span[text()[normalize-space()='Job']]")
    WebElement adminJobBtn;

    @FindBy(xpath = "//a[text()[normalize-space()='Job Titles']]")
    WebElement adminJobTitleLink;

    @FindBy(xpath = "//button[text()[normalize-space()='Add']]")
    WebElement adminJobTitleAddBtn;

    @FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div/input")
    WebElement adminJobTitle;

    @FindBy(xpath = "//label[text()='Job Description']/../following-sibling::div/textarea")
    WebElement adminJobDesc;

    @FindBy(xpath = "//span[text()='Show More']")
    WebElement adminJobDescMore;

    @FindBy(xpath = "//div[text()='Quality Assurance']/../following-sibling::div//span[text()=\"Responsible for monitoring and improve an organization's final products.\"]")
    WebElement adminJobDescDisplayed;

    @FindBy(xpath = "//span[text()[normalize-space()='Required']]")
    WebElement adminJobTitleError;

    @FindBy(xpath = "//p[text()[normalize-space()='Successfully Saved']]")
    WebElement adminJobTitleAddSuccess;

    @FindBy(xpath = "//p[text()[normalize-space()='Successfully Updated']]")
    WebElement adminJobTitleSuccessUpdate;

    @FindBy(xpath = "//div[text()[normalize-space()='Quality Assurance']]")
    List<WebElement> adminJobTitleDisplayed;

    @FindBy(xpath = "//div[text()[normalize-space()='Quality Assurance']]/../following-sibling::div//i[contains(@class,'bi-pencil-fill')]")
    WebElement adminEditJobTitleBtn;

    @FindBy(xpath = "//div[text()[normalize-space()='Quality Assurance']]/../following-sibling::div//i[contains(@class,'bi-trash')]")
    WebElement adminDltJobTitleBtn;

    @FindBy(xpath = "//div[contains(@class,'orangehrm-dialog-popup')]")
    WebElement adminDltPopupConfirmation;

    @FindBy(xpath = "//button[text()[normalize-space()='Yes, Delete']]")
    WebElement adminPopupConfirmDltBtn;

    @FindBy(xpath = "//p[text()[normalize-space()='Successfully Deleted']]")
    WebElement adminJobTitleSuccessDelete;

    @FindBy(xpath = "//button[text()[normalize-space()='Save']]")
    WebElement adminSaveButton;

    @FindBy(xpath = "//button[text()[normalize-space()='Cancel']]")
    WebElement adminCancelButton;

    @FindBy(xpath = "//button[text()[normalize-space()='Yes, Delete']]")
    WebElement jobTitleConfirmDltBtn;

    @FindBy(xpath = "//button[text()[normalize-space()='No, Cancel']]")
    WebElement jobTitleConfirmCancelBtn;

    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
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
    public void clickCancelButton(){
        adminCancelButton.click();
    }
    public boolean usernameDisplayed(){
        return adminUsernameResult.isDisplayed();
    }
    public boolean usernameNotDisplayed(){
        return adminErrorUsername.isDisplayed();
    }
    public void clickJobBtn(){
        adminJobBtn.click();
    }
    public boolean verifySuccessAddMsg(){
        return adminJobTitleAddSuccess.isDisplayed();
    }
    public boolean verifySuccessfullyUpdate(){
        return adminJobTitleSuccessUpdate.isDisplayed();
    }
    public boolean verifyDltPopupConfirmation(){
        return adminDltPopupConfirmation.isDisplayed();
    }
    public void clickPopupConfirmDltBtn(){
        adminPopupConfirmDltBtn.click();
    }
    public boolean verifySuccessfullyDeleted(){
        return adminJobTitleSuccessDelete.isDisplayed();
    }
    public boolean adminLinkDisplayed(){
        return adminLink.isDisplayed();
    }
    public void clickAdmin(){
        boolean isDisplay = adminLink.isDisplayed();
        if(isDisplay){
            adminLink.click();
        }
    }
    public void clickJobTitle(){
        boolean isDisplay = adminLink.isDisplayed();
        if(isDisplay){
            adminLink.click();
        }
        adminJobBtn.click();
        adminJobTitleLink.click();
    }
    public void inputJobDescInput(String jobDesc){
        adminJobDesc.click();
        adminJobDesc.sendKeys(jobDesc);
    }
    public void clickSaveBtn(){
        adminSaveButton.click();
    }
    public boolean errorDisplayed(){
        return adminJobTitleError.isDisplayed();
    }
    public void clickEditJobTitleBtn(){
        adminEditJobTitleBtn.click();
    }
    public void clickJobTitleDescMoreBtn(){
        adminJobDescMore.click();
    }
    public boolean checkJobDescDisplayed(){
        return adminJobDescDisplayed.isDisplayed();
    }
    public void clearInputJobTitle() throws InterruptedException{
        adminJobTitle.click();
        adminJobTitle.sendKeys(Keys.CONTROL,"A");
        adminJobTitle.sendKeys(Keys.DELETE);
    }
    public void addJobTitle(){
        adminJobTitleAddBtn.click();
    }
    public boolean verifyJobTitleExistance(){
        int count = adminJobTitleDisplayed.size();
        return count > 0;
    }
    public void inputJobTitle(String jobTitle){
        adminJobTitle.click();
        adminJobTitle.sendKeys(jobTitle);
    }
    public void editJobDesc(String jobDesc){
        boolean isExist = adminEditJobTitleBtn.isDisplayed();
        if(isExist) {
            adminEditJobTitleBtn.click();
            adminJobDesc.click();
            adminJobDesc.sendKeys(jobDesc);
        }
    }
    public void clearEditJobDesc(String jobDesc){
        boolean isExist = adminEditJobTitleBtn.isDisplayed();
        if(isExist) {
            adminEditJobTitleBtn.click();
            adminJobDesc.click();
            adminJobDesc.sendKeys(Keys.CONTROL,"A");
            adminJobDesc.sendKeys(Keys.DELETE);
            adminJobDesc.sendKeys(jobDesc);
        }
    }
    public void dltJobTitle(){
        boolean isExist = adminDltJobTitleBtn.isDisplayed();
        if(isExist) {
            adminDltJobTitleBtn.click();
        }
        boolean isDisplay = adminDltPopupConfirmation.isDisplayed();
        if(isDisplay){
            jobTitleConfirmDltBtn.click();
        }
    }
    public void cancelDltJobTitle(){
        boolean isExist = adminDltJobTitleBtn.isDisplayed();
        if(isExist) {
            adminDltJobTitleBtn.click();
        }
        boolean isDisplay = adminDltPopupConfirmation.isDisplayed();
        if(isDisplay){
            jobTitleConfirmCancelBtn.click();
        }
    }
}
