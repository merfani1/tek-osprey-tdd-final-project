package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

import java.util.prefs.BackingStoreException;

public class UserProfilePage extends SeleniumUtilities {

    public UserProfilePage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/button")
    public WebElement profileBtn;

    @FindBy(xpath = "//span[@class='css-1ny2kle']")
    public WebElement StatusActive;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div/div/div/div[2]/p[2]")
    public WebElement userTypeText;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div/div/div/div[3]/p[2]")
    public WebElement validateFullName;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div/div/div/div[4]/p[2]")
    public WebElement validateUserName;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div/div/div/div[5]/ul/li")
    public WebElement validateAuthority;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/footer/div/button[1]")
    public WebElement logoutBtn;

    @FindBy(xpath = "//button[@class='chakra-button css-1x18d5s']")
    public WebElement LogoutButton;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/h2")
    public WebElement customerServicePortal;



}
