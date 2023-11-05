package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage extends TestBase {
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div//input")
    WebElement loginUsername;

    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div//input")
    WebElement loginPassword;

    @FindBy(xpath = "//button[text()[normalize-space() = 'Login']]")
    WebElement loginButton;

    //error message
    @FindBy(xpath = "//p[text() = 'Invalid credentials']")
    WebElement loginErrMsg;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterLoginCreds(String username, String password) throws InterruptedException {
        loginUsername.sendKeys(username);
        loginPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public boolean errorMsgDisplayed(){
        return loginErrMsg.isDisplayed();
    }

    public String errorMsgDisplayed2(){
        return loginErrMsg.getText();
    }


}
