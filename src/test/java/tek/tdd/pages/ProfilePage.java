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

    @FindBy(className = "chakra-modal__header")
    public WebElement profileText;
}
