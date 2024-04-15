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

    @FindBy(className = "chakra-button")
    public WebElement CreatePAccountlink;

}
