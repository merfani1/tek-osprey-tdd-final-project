package tek.tdd.test.functional;

import tek.tdd.base.BaseUITests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageSteps extends BaseUITests {
    //Validate When user navigate to home page title is TEK Insurance UI and create Primary Account
    //Button is existed
    @Test
    public void testInsuranceLogo() {

        String expectedTitle="TEK Insurance App";
        String actualTitle=getElementText(homePage.topNavLogo);
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void validateLoginButtonIsEnabled() {
       // create Primary Account Button is existed
        boolean isSignInButtonEnabled = isElementEnabled(homePage.CreatePAccountlink);
        Assert.assertTrue(isSignInButtonEnabled, "Sign in button should be enabled all time");
    }

}
