package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class LoginPage extends SeleniumUtilities {
    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/a[2]")
    public WebElement LogingButton;

    @FindBy(name = "username")
    public WebElement UserNameInput;

    @FindBy(name = "password")
    public WebElement PasswordInput;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/div/form/div/div[3]/button[1]")
    public WebElement SignInButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/h2")
    public WebElement CustomerServicePortalText;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/div/div")
    public WebElement wrongUsernameOrPassword;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/div/div")
    public WebElement wrongPassword;

    public void DoLogin(String userName, String Password ){
        sendText(UserNameInput,userName);
        sendText(PasswordInput,Password);

        clickOnElement(SignInButton);
    }

}

