package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.base.BaseUITests;
import tek.tdd.utilities.SeleniumUtilities;

public class LoginPage extends SeleniumUtilities {
    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id = "username")
    public WebElement UserNameInput;

    @FindBy(id = "password")
    public WebElement PasswordInput;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/div/form/div/div[3]/button[1]")
    public WebElement SignInButton;

    public void doLogin(String username, String password) {
        sendText(UserNameInput, username);
        sendText(PasswordInput, password);
        clickOnElement(SignInButton);
    }
    @FindBy(className = "chakra-alert__title")
    public WebElement errorMessage;


}
