package tek.tdd.test.functional;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;

import java.text.ParseException;

public class PlansTest extends BaseUITests {
    /*Plans
    Scenario 1)
    Navigate to Customer Service Portal with valid CSR credentials and navigate to Plans Page.
    Validate 4 row of data is present.
     */
    @DataProvider(name = "validCredential_CSP")
    public String[][] validCredential() {
        String[][] data = {
                {"supervisor", "tek_supervisor"}
        };
        return data;
    }
    @Test(dataProvider = "validCredential_CSP")
    public void Navigat_Customer_Service_Portal(String UserName, String Password) throws InterruptedException {
        clickOnElement(loginPage.LogingButton);
        loginPage.DoLogin(UserName,Password);

        Thread.sleep(2000);
        clickOnElement(plansPage.PlansLink);
        Thread.sleep(5000);
        plansPage.countRowAndColumn();
    }
    /*
    Scenario 2)
    Navigate to Customer Service Portal with valid CSR credentials and navigate to Plans Page. Then
     validate Create Date is todays date in (EST Time zone) and Date Expire is a day after (EST Time
     Zone)
     */
    @Test(dataProvider = "validCredential_CSP")
    public void validateCreateDatePlans(String UserName,String Password) throws InterruptedException {
        clickOnElement(loginPage.LogingButton);
        loginPage.DoLogin(UserName,Password);

        Thread.sleep(2000);
        clickOnElement(plansPage.PlansLink);
        Thread.sleep(2000);
        plansPage.validateCreateDate();


    }
    @Test(dataProvider = "validCredential_CSP")
    public void validateExpireDatePlans(String UserName,String Password) throws InterruptedException, ParseException {
        clickOnElement(loginPage.LogingButton);
        loginPage.DoLogin(UserName,Password);

        Thread.sleep(2000);
        clickOnElement(plansPage.PlansLink);
        Thread.sleep(2000);
        plansPage.validateExpireDatePlan();

    }
}
