package tek.tdd.test.functional;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;
public class loginTest extends BaseUITests {
    /*
    Login:
    Scenario 1)
    Navigate to login by clicking on Login button and enter valid csr user
    Username: supervisor
    Password: tek_supervisor
    And validate user navigate to Customer Service Portal

    Scenario 2)
    Navigate to login and enter wrong credentials and validate error message as expected
    Note both wrong username and wrong password should tested
 */
    @DataProvider(name = "verifyCredential_Login")
    public String[][] verifyLoginCredentialsPro() {
        String[][] data = {
                {"supervisor", "tek_supervisor","bothCorrect"},
                {"supervisor4", "tek_supervisor","CorrectPassword"},
                {"supervisor", "tek_supervisor4","CorrectUserName"}
        };
        return data;
    }
    @Test(dataProvider = "verifyCredential_Login")
    public void verifyLoginCredentials(String userName, String password,String Scenario) throws InterruptedException {
        clickOnElement(loginPage.LogingButton);
        loginPage.DoLogin(userName, password);
        if (Scenario.equals("bothCorrect")) {
            Thread.sleep(5000);
            String expectedCSP = "Customer Service Portal";
            String actualCSPText = getElementText(loginPage.CustomerServicePortalText);
            Assert.assertEquals(actualCSPText, expectedCSP);
        } else if (Scenario.equals("CorrectPassword")) {
            String expectWrongUsername="User "+userName+" not found";
            String actualErrorMessages= getElementText(loginPage.wrongUsernameOrPassword);
            String deleteErrorText=actualErrorMessages.replace("ERROR","").trim();
            Assert.assertEquals(expectWrongUsername,deleteErrorText);
        } else if (Scenario.equals("CorrectUserName")) {

            String expectedWrongPassword="Password not matched";
            String actualErrorMessages= getElementText(loginPage.wrongPassword);
            String deleteErrorText=actualErrorMessages.replace("ERROR","").trim();
            Assert.assertEquals(expectedWrongPassword,deleteErrorText);
        }else {
            System.out.println("Please try again");
        }
    }
}
