package tek.tdd.test.regression;

import org.testng.annotations.DataProvider;
import tek.tdd.base.BaseUITests;
import org.testng.Assert;

import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;

public class SecurityTest extends BaseUITests {

    @DataProvider(name = "validCredential")
    public String[][] validCredentialProvider() {
        String[][] data = {
                {"supervisor", "tek_supervisor"},
        };
        return data;
    }
    @Test(dataProvider = "validCredential")
    public void validateLoginWithValidCredentials(String username, String password) {
    /*
    Navigate to login by clicking on Login button and enter valid csr user
    Username: supervisor
    Password: tek_supervisor
    And validate user navigate to Customer Service Portal
     */
        clickOnElement(homePage.LoginButton);
        loginPage.doLogin(username,password);

    }
    @DataProvider(name = "InValidCredential")
    public String [][] InValidCredentialProvider(){
        String[][] data = {
                {"supervisor_tek", "tek_supervisor"},
                {"supervisor", "supervisor@123"}
        };
        return data;
    }
    // testing wrong username and password
    @Test(dataProvider = "InValidCredential")
    public void InValidCredentials(String username,String password){
        clickOnElement(homePage.LoginButton);
        loginPage.doLogin(username,password);
        String expectedErrorMessage="ERROR Password not matched";
        // need locator for error message
        String actualErrorMessage=getElementText(loginPage.errorMessage);
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

}
