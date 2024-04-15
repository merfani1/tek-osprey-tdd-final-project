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
}
