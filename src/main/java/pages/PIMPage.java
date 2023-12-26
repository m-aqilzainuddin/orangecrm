package pages;

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
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement empFirstName;
    @FindBy(xpath = "//input[@name='middleName']")
    WebElement empMidName;
    @FindBy(xpath = "//input[@name='lastName']")
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

    //Personal-Details Employee (For-Update)
    @FindBy(xpath = "//a[text()='Personal Details']")
    WebElement empPersonalDetailsLink;
    @FindBy(xpath = "//label[text()='Nationality']/../following-sibling::div")
    WebElement empNationality;
    @FindBy(xpath = "//label[text()='Nationality']/../following-sibling::div//span[contains(text(),'Malaysian')]")
    WebElement empSelectNationality;
    @FindBy(xpath = "//label[text()='Male']")
    WebElement empGenderMale;
    @FindBy(xpath = "//label[text()='Female']")
    WebElement empGenderFemale;

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


    //EMPLOYEE METHOD
    public void clickPIMLink(){
        boolean isDisplay = pimLink.isDisplayed();
        if(isDisplay){
            pimLink.click();
        }
    }
    public void failAddEmployeeWithoutLoginDetails(){
        globalAddBtn.isDisplayed();
        globalAddBtn.click();
        globalSaveButton.isDisplayed();
        globalSaveButton.click();
        globalInputRequired.isDisplayed();
    }
    public void failAddEmployeeWithLoginDetails(String fname,String lname,String username){
        globalAddBtn.isDisplayed();
        globalAddBtn.click();
        empFirstName.sendKeys(fname);
        empLastName.sendKeys(lname);
        empCreateLoginToggle.isDisplayed();
        empCreateLoginToggle.click();
        empUsername.sendKeys(username);
        globalSaveButton.isDisplayed();
        globalSaveButton.click();
        globalInputRequired.isDisplayed();
    }
    public void cancelAddEmployeeWithoutLoginDetails(String fname,String lname, String fullname){
        globalAddBtn.isDisplayed();
        globalAddBtn.click();
        empFirstName.sendKeys(fname);
        empLastName.sendKeys(lname);
        globalCancelButton.isDisplayed();
        globalCancelButton.click();
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.isDisplayed();
        globalSearchBtn.click();
    }
    public void cancelAddEmployeeWithLoginDetails(String fname,String lname,String username,String pass,String cpass,String fullname){
        globalAddBtn.isDisplayed();
        globalAddBtn.click();
        empFirstName.sendKeys(fname);
        empLastName.sendKeys(lname);
        empCreateLoginToggle.isDisplayed();
        empCreateLoginToggle.click();
        empUsername.sendKeys(username);
        empPass.click();
        empPass.sendKeys(pass);
        empConfirmPass.click();
        empConfirmPass.sendKeys(cpass);
        globalCancelButton.isDisplayed();
        globalCancelButton.click();
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.isDisplayed();
        globalSearchBtn.click();
    }
    public void successAddEmployeeWithoutLoginDetails(String fname,String lname, String fullname){
        globalAddBtn.isDisplayed();
        globalAddBtn.click();
        empFirstName.sendKeys(fname);
        empLastName.sendKeys(lname);
        globalSaveButton.isDisplayed();
        globalSaveButton.click();
        globalSuccessfullySaveMsg.isDisplayed();
        pimLink.isDisplayed();
        pimLink.click();
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.isDisplayed();
        globalSearchBtn.click();
    }
    public void successAddEmployeeWithLoginDetails(String fname,String lname,String username,String pass,String cpass,String fullname){
        globalAddBtn.isDisplayed();
        globalAddBtn.click();
        empFirstName.sendKeys(fname);
        empLastName.sendKeys(lname);
        empCreateLoginToggle.isDisplayed();
        empCreateLoginToggle.click();
        empUsername.sendKeys(username);
        empPass.click();
        empPass.sendKeys(pass);
        empConfirmPass.click();
        empConfirmPass.sendKeys(cpass);
        globalSaveButton.isDisplayed();
        globalSaveButton.click();
        globalSuccessfullySaveMsg.isDisplayed();
        pimLink.isDisplayed();
        pimLink.click();
        empSearchByName.click();
        empSearchByName.sendKeys(fullname);
        globalSearchBtn.isDisplayed();
        globalSearchBtn.click();
    }
    public boolean verifyEmployeeExist() {
        int count = empDisplayFName.size()&empDisplayLName.size();
        return count > 0;
    }


    //REPORT


}
