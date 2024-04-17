package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class CreateAccountPage extends SeleniumUtilities {

    public CreateAccountPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/h2")
    public WebElement TextAccountTitle;

    @FindBy(id="email")
    public WebElement emailInput;
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "gender")
    public WebElement genderInput;

    @FindBy(id = "employmentStatus")
    public WebElement EmpStatus;

    @FindBy (id = "title")
    public WebElement TitlePrefix;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "maritalStatus")
    public WebElement maritalSt;

    @FindBy(id = "dateOfBirth")
    public WebElement DoB;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/form/div/div[2]/button[1]")
    public WebElement createAccountBt;

    public void createAccount( String email,
                               String FirstName,
                               String LastName,
                               String EmploymentStatus,
                               String DateOfBirth){
        sendText(emailInput,email);
        sendText(firstName,FirstName);
        sendText(lastName,LastName);
        sendText(EmpStatus,EmploymentStatus);
        sendText(DoB,DateOfBirth);

    }
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/h2[3]")
    public WebElement EmailAddress;

    @FindBy(className = "chakra-alert__title")
    public WebElement ErrorMessageExsitingAc;

}
