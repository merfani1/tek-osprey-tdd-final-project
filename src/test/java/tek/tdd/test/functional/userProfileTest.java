package tek.tdd.test.functional;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;
public class userProfileTest extends BaseUITests {
    /*User Profile:
    Scenario 1)
    Navigate to login and enter valid CSR credentials and navigate to Customer Service Portal then
    click on profile button validate information is in Profile Side Drawer is correct.

     */
/*
    @DataProvider(name = "validCredentialPro")
    public String[][] validCredentialProfile() {
        String[][] data = {
                {"supervisor", "tek_supervisor","Active","CSR","Supervisor","supervisor","admin"}
                //
        };
        return data;
    }
    @Test(dataProvider = "validCredentialPro")
    public void validateLoginWithValidCredential(String username,String password,String Status,String userType,String FullName, String userName,String Authorities
                                                ) throws InterruptedException {
        //,,
            clickOnElement(homePage.LoginButton);
            loginPage.DoLogin(username,password);
            Thread.sleep(5000);
            waitForVisibility(userProfilePage.profileBtn);
            clickOnElement(userProfilePage.profileBtn);
            Thread.sleep(5000);


      waitForVisibility(userProfilePage.StatusActive);
      String actualStatus=getElementText(userProfilePage.StatusActive);
        Assert.assertEquals(Status,actualStatus);

        String actualUserType=getElementText(userProfilePage.UserType);
        Assert.assertEquals(userType,actualUserType);

        String actualFullName=getElementText(userProfilePage.fullName);
        Assert.assertEquals(FullName,actualFullName);

        String actualUserName=getElementText(userProfilePage.userName);
        Assert.assertEquals(userName,actualUserName);

        String actualAuthorities=getElementText(userProfilePage.Authorities);
       Assert.assertEquals(Authorities,actualAuthorities);

       System.out.println("You are successfully clicked on profile ");
    }

 */

    /*
    Scenario 2)
    Navigate to login and enter valid CSR credentials and navigate to Customer Service Portal then
    click on profile button and then click on Logout button make sure user navigate to home page
     */
    @DataProvider(name = "validCredential")
    public String[][] validCredential() {
        String[][] data = {
                {"supervisor", "tek_supervisor"}
        };
        return data;
    }
    @Test(dataProvider = "validCredential")
    public void LoginWithValidCredential(String userName,String Password) throws InterruptedException {
        clickOnElement(homePage.LoginButton);
        loginPage.DoLogin(userName,Password);
       Thread.sleep(5000);
        waitForVisibility(userProfilePage.customerServicePortal);
        String expectedTitle="Customer Service Portal";
        String actualTitle=getElementText(userProfilePage.customerServicePortal);
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println(actualTitle);


        waitForClickable(userProfilePage.profileBtn);
        clickOnElement(userProfilePage.profileBtn);


        clickOnElement(userProfilePage.LogoutButton);
        System.out.println("You are successfully logout");


    }

}
