package tek.tdd.test.functional;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;

public class accountsSteps extends BaseUITests {
    /*
    Accounts
    Scenario 1)
    Navigate to Customer Service Portal with valid CSR credentials and navigate to Accounts verify
    5 row /page is default
     */
    @DataProvider(name = "validCredential_Account")
    public String[][] validCredential() {
        String[][] data = {
                {"supervisor", "tek_supervisor"}
        };
        return data;
    }
    @Test(dataProvider = "validCredential_Account")
    public void testDefaultRowsPerPage(String UserName, String Password) throws InterruptedException {
        clickOnElement(loginPage.LogingButton);
        loginPage.DoLogin(UserName,Password);

        Thread.sleep(2000);


    }
}
