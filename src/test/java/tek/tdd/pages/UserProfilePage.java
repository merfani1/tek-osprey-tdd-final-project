package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class ProfilePage extends SeleniumUtilities {

    public ProfilePage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/button")
    public WebElement profileBtn;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div/header")
    public WebElement profileText;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div/div/div/div/div[1]/p[2]/span/span")
    public WebElement StatusActive;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div/div/div/div/div[2]/p[2]")
    public WebElement UserType;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div/div/div/div/div[3]/p[2]")
    public WebElement fullName;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div/div/div/div/div[4]/p[2]")
    public WebElement userName;

 @FindBy(xpath = "/html/body/div[4]/div[3]/div/div/div/div/div/div[5]/ul/li")
 public WebElement Authorities;

    @FindBy(className = "chakra-button")
    public WebElement LogoutButton;


}