package tek.tdd.test.functional;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;

public class ProfileSteps extends BaseUITests {
    /*
    Navigate to login and enter valid CSR credentials and navigate to Customer Service Portal then
    click on profile button validate information is in Profile Side Drawer is correct.
     */
    @DataProvider(name = "validCredentialPro")
    public String[][] validCredentialProfile() {
        String[][] data = {
                {"supervisor", "tek_supervisor","Profile"}
        };
        return data;
    }
    @Test(dataProvider = "validCredentialPro")
    public void validateLoginWithValidCredential(String username,String password,String expectedText){
        clickOnElement(homePage.LoginButton);
        loginPage.doLogin(username,password);

        clickOnElement(profilePage.profileBtn);

        String actualText=getElementText(profilePage.profileText);
        Assert.assertEquals(expectedText,actualText);

    }
}
