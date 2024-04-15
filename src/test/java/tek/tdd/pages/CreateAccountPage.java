package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class CreateAccountPage extends SeleniumUtilities {

    public CreateAccountPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(className = "chakra-heading css-1jb3vzl")
    public WebElement TextAccountTitle;

    @FindBy(id="email")
    public WebElement emailInput;
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "gender")
    public WebElement genderInput;
}
