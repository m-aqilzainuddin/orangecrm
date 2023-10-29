import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//*[@name=\"username\"]" )
    WebElement userName;

    @FindBy(xpath = "//*[@name=\"password\"]")
    WebElement passWord;
}
