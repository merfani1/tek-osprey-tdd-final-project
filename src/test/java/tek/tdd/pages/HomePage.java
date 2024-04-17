package tek.tdd.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class HomePage extends SeleniumUtilities {
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    //driver.findElement(By.className("className"))
    @FindBy(className = "chakra-heading")
    public WebElement topNavLogo;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/a")
    public WebElement CreatePAccountlink;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/a[2]")
    public WebElement LoginButton;

    @FindBy(className = "chakra-button")
    public WebElement loginButton;

}
