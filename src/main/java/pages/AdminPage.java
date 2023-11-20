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

    @FindBy(xpath = "//button[text()[normalize-space()='Add']]")
    WebElement adminAddButton;

    @FindBy(xpath = "//label[text()='User Role']/../following-sibling::div//div[@class=\"oxd-select-text-input\"]")
    WebElement adminUserRole;

    @FindBy(xpath = "//label[text()='Employee Name']/../following-sibling::div//input")
    WebElement adminEmployeeName;

    @FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[@class=\"oxd-select-text-input\"]")
    WebElement adminStatus;

    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div/input")
    WebElement adminPassword;

    @FindBy(xpath = "//label[text()='Confirm Password']/../following-sibling::div/input")
    WebElement adminConfirmPassword;

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

    @FindBy(xpath = "//span[text()[normalize-space()='Required']]")
    WebElement adminJobTitleError;

    @FindBy(xpath = "//p[text()[normalize-space()='Successfully Saved']]")
    WebElement adminJobTitleSuccess;

    @FindBy(xpath = "//p[text()[normalize-space()='Successfully Updated']]")
    WebElement adminJobTitleSuccessUpdate;

    @FindBy(xpath = "//div[text()[normalize-space()='Quality Assurance']]")
    List<WebElement> adminJobTitleDisplayed;

    @FindBy(xpath = "//div[text()[normalize-space()='Quality Assurance']]/../following-sibling::div//i[contains(@class,'bi-pencil-fill')]")
    WebElement adminEditJobTitleBtn;

    @FindBy(xpath = "//button[text()[normalize-space()='Save']]")
    WebElement adminSaveButton;

    @FindBy(xpath = "//button[text()[normalize-space()='Cancel']]")
    WebElement adminCancelButton;

    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkAdminLink(){
        return adminLink.isDisplayed();
    }
    public void clickAdminLink(){
        adminLink.click();
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
    public void clickJobTitleLink(){
        adminJobTitleLink.click();
    }
    public void clickJobTitleAddBtn(){
        adminJobTitleAddBtn.click();
    }
    public void inputJobDescInput(String jobDesc){
        adminJobDesc.click();
        adminJobDesc.sendKeys(jobDesc);
    }
    public void inputJobTitle(String jobTitle){
        adminJobTitle.click();
        adminJobTitle.sendKeys(jobTitle);
    }
    public void clickSaveBtn(){
        adminSaveButton.click();
    }
    public boolean errorDisplayed(){
        return adminJobTitleError.isDisplayed();
    }
    public boolean verifySuccessAddMsg(){
        return adminJobTitleSuccess.isDisplayed();
    }
    public boolean verifyJobTitleExistance(){
        int count = adminJobTitleDisplayed.size();
        return count > 0;
    }
    public void clickEditJobTitleBtn(){
        adminEditJobTitleBtn.click();
    }
    public void clearInputJobTitle() throws InterruptedException {
        adminJobTitle.click();
        adminJobTitle.sendKeys(Keys.CONTROL,"A");
        adminJobTitle.sendKeys(Keys.DELETE);
    }

    public boolean verifySuccessfullyUpdate(){
        return adminJobTitleSuccessUpdate.isDisplayed();
    }
}
