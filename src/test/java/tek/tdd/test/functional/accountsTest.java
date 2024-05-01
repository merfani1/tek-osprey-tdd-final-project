package tek.tdd.test.functional;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;

public class accountsTest extends BaseUITests {
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
        clickOnElement(accountsPage.accountLink);

        accountsPage.verifyAccountRows();


    }
    /*
    Scenario 2)
    Navigate to Customer Service Portal with valid CSR credentials and navigate to Accounts change
    show per page to 10, 25, 50 and validate table records per page according to selected show per
    page.
     */
 @Test(dataProvider = "validCredential_Account")
    public void validateRecordsPerPages(String UserName,String Password) throws InterruptedException {
     clickOnElement(loginPage.LogingButton);
     loginPage.DoLogin(UserName,Password);
     Thread.sleep(2000);
     clickOnElement(accountsPage.accountLink);
     Thread.sleep(2000);
     accountsPage.validateRecordsPerPages();
     Thread.sleep(2000);
 }
}
