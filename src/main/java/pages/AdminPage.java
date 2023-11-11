package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AdminPage extends TestBase {
    @FindBy(xpath = "//a[contains(@href, 'viewAdminModule')]")
    WebElement adminLink;

    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div/input")
    WebElement adminUsername;

    @FindBy(xpath = "//div[text()='Admin']")
    WebElement adminUsernameResult;

    @FindBy(xpath = "//button[text()=\" Search \"]")
    WebElement adminSearchButton;

    @FindBy(xpath = "//button[text()=\" Reset \"]")
    WebElement adminResetButton;

    @FindBy(xpath = "//button[text()[normalize-space() = 'Add']]")
    WebElement adminAddButton;

    @FindBy(xpath = "//label[text()=\"User Role\"]/../following-sibling::div//div[@class=\"oxd-select-text-input\"]")
    WebElement adminUserRole;

    @FindBy(xpath = "//label[text()=\"Employee Name\"]/../following-sibling::div//input")
    WebElement adminEmployeeName;

    @FindBy(xpath = "//label[text()=\"Status\"]/../following-sibling::div//div[@class=\"oxd-select-text-input\"]")
    WebElement adminStatus;

    @FindBy(xpath = "//label[text()=\"Password\"]/../following-sibling::div/input")
    WebElement adminPassword;

    @FindBy(xpath = "//label[text()=\"Confirm Password\"]/../following-sibling::div/input")
    WebElement adminConfirmPassword;

    @FindBy(xpath = "//button[text()=\" Save \"]")
    WebElement adminSaveButton;

    @FindBy(xpath = "//button[text()=\" Cancel \"]")
    WebElement adminCancelButton;

    public AdminPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean checkAdminLink(){
        return adminLink.isDisplayed();
    }
    public void clickAdminLink(){
        adminLink.click();
    }
    public void enterSystemUsername(String username){
        adminUsername.sendKeys(username);
    }
    public void clickSearchButton(){
        adminSearchButton.click();
    }
    public void clickCancelButton(){
        adminCancelButton.click();
    }
    public boolean usernameDisplayed(){
        return adminUsernameResult.isDisplayed();
    }

}