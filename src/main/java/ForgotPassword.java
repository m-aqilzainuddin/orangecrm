import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
    @FindBy(xpath = "div[class*=\"forgot\"] > p")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//button[text()[normalize-space() = 'Reset Password']]")
    WebElement resetButtons;
    @FindBy(xpath = "[class*=\"orangehrm-forgot-password-button--reset\"]")
    WebElement resetButton;

    @FindBy(xpath = "//button[text()[normalize-space() = 'Cancel']]")
    WebElement cancelButton;

}
