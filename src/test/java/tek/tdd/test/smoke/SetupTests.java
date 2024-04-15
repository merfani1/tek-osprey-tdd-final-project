package tek.tdd.test.smoke;

import tek.tdd.base.BaseUITests;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.pages.HomePage;
public class SetupTests extends BaseUITests {
    //Validate When user navigate to home page title is TEK Insurance UI and create Primary Account
    //Button is exist
    @Test
    public void testInsuranceLogo() {
       /* boolean isDisplayed = isElementDisplayed(homePage.topNavLogo);
            Assert.assertTrue(isDisplayed,
             "Top left corner Logo should displayed always");
        */
        String expectedTitle="TEK Insurance App";
        String actualTitle=getElementText(homePage.topNavLogo);
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Test
    public void validateLoginButtonIsEnabled() {
        //Navigate to retail app and make sure Sign in button is enabled.
        boolean isSignInButtonEnabled = isElementEnabled(homePage.CreatePAccountlink);
        Assert.assertTrue(isSignInButtonEnabled, "Sign in button should be enabled all time");
    }

}
