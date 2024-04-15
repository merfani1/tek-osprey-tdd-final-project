package tek.tdd.test.regression;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;


public class CreateAccountSteps extends BaseUITests{
    /*
    Create Account:
    Scenario 1)
    Navigate to Home page then click on Create Primary Account Button. User should navigate to
    Create Account form page validate Form Title as Expected “Create Primary Account Holder”
    */
    @Test
    public void userClickOnCreateAccount(){
       // clickOnElement(homePage.CreatePAccountlink);
    }
    @Test
    public void validateFormAndTitle(){

       // String expectedTitle="Create Primary Account Holder";
       // String actualTitle=getElementText(createAccountPage.TextAccountTitle);
       // Assert.assertEquals(expectedTitle,actualTitle);
    }
}
