package tek.tdd.test.regression;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;

import java.security.SecureRandom;


public class CreateAccountSteps extends BaseUITests{
    /*
    Create Account:
    Scenario 1)
    Navigate to Home page then click on Create Primary Account Button. User should navigate to
    Create Account form page validate Form Title as Expected “Create Primary Account Holder”
    */
    @Test
    public void userClickOnCreateAccount(){
        clickOnElement(homePage.CreatePAccountlink);

    }
    @Test
    public void validateFormAndTitle(){
        clickOnElement(homePage.CreatePAccountlink);

        String expectedTitle="Create Primary Account Holder";
        String actualTitle=getElementText(createAccountPage.TextAccountTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @DataProvider(name = "validCredentials")
    private String[][] validCredentialProvider(){
        String[][]data={
                {"reza.safar19@gmail.com","Reza","Teacher","safari","12/15/1999"}
        };
        return data;
    }

    @Test(dataProvider = "validCredentials")
    public void user_fillSignUpForm(
            String email,
            String FirstName,
            String LastName,
            String EmploymentStatus,
            String DateOfBirth

    ){
        clickOnElement(homePage.CreatePAccountlink);
        createAccountPage.createAccount(email,FirstName,LastName,EmploymentStatus,DateOfBirth);

        selectFromDropDown(createAccountPage.genderInput,"Male");
        selectFromDropDown(createAccountPage.TitlePrefix,"Mr.");
        selectFromDropDown(createAccountPage.maritalSt,"Married");
        clickOnElement(createAccountPage.createAccountBt);

        //Validate user navigate to Sing up your Account page and email address shows as expected.

        String actualEmail= getElementText(createAccountPage.EmailAddress);
        Assert.assertEquals(actualEmail,email,"Email should display all the time");
        System.out.println(actualEmail);


    }

    @DataProvider(name = "existingCredentials")
    private String[][] existingCredentialProvider(){
        String[][]data={
                {"reza.safar1@gmail.com","Reza","Teacher","safari","12/15/1999","ERROR"}
        };
        return data;
    }
    @Test(dataProvider = "existingCredentials")
    public void CreateAccountWithExistingUser(
            String email,
            String FirstName,
            String LastName,
            String EmploymentStatus,
            String DateOfBirth,
            String expectedErrorMessage

    ){
        clickOnElement(homePage.CreatePAccountlink);
        createAccountPage.createAccount(email,FirstName,LastName,EmploymentStatus,DateOfBirth);

        selectFromDropDown(createAccountPage.genderInput,"Male");
        selectFromDropDown(createAccountPage.TitlePrefix,"Mr.");
        selectFromDropDown(createAccountPage.maritalSt,"Married");
        clickOnElement(createAccountPage.createAccountBt);

        // should add error message with Assert
       String actualErrorMessages= getElementText(createAccountPage.ErrorMessageExsitingAc);
       Assert.assertEquals(expectedErrorMessage,actualErrorMessages);



    }





}
