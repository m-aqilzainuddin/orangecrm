package pages;

import org.openqa.selenium.WebDriver;
import utils.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div//input")
    WebElement loginUsername;

    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div//input")
    WebElement loginPassword;

    @FindBy(xpath = "//button[text()[normalize-space() = 'Login']]")
    WebElement loginButton;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutButton;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement userMenuDropdown;

    //error message
    @FindBy(xpath = "//p[text() = 'Invalid credentials']")
    WebElement loginErrMsg;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterLoginCreds(String username, String password) throws InterruptedException {
        loginUsername.sendKeys(username);
        loginPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void logout() {
        userMenuDropdown.click();
        logoutButton.click();
    }

    public boolean errorMsgDisplayed(){
        return loginErrMsg.isDisplayed();
    }

    public String errorMsgDisplayed2(){
        return loginErrMsg.getText();
    }


}
