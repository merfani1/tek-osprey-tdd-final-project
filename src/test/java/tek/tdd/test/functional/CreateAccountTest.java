package tek.tdd.test.functional;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;
import tek.tdd.utilities.DataGenerator;

public class CreateAccountTest extends BaseUITests{
    /*
    Create Account:
    Scenario 1)
    Navigate to Home page then click on Create Primary Account Button. User should navigate to
    Create Account form page validate Form Title as Expected “Create Primary Account Holder”
    */
    String generateRandomEmail;
    @Test
    public void validateFormAndTitle(){
        clickOnElement(homePage.CreatePAccountlink);

        String expectedTitle="Create Primary Account Holder";
        String actualTitle=getElementText(createAccountPage.TextAccountTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    /*
    Scenario 2)
    On Create primary account holder form fill up the form and click on create Account Button
    Validate user navigate to Sing up your Account page and email address shows as expected.
     */
    @DataProvider(name = "validCredentials")
    private String[][] validCredentialProvider(){
        String[][]data={
                {"Reza","Teacher","safari","12/15/1999"}
        };
        return data;
    }
    @Test(dataProvider = "validCredentials")
    public void user_fillSignUpForm(

            String FirstName,
            String LastName,
            String EmploymentStatus,
            String DateOfBirth

    ) {
        clickOnElement(homePage.CreatePAccountlink);

        createAccountPage.createAccountWithRandomEmail(FirstName,LastName,EmploymentStatus,DateOfBirth);
        generateRandomEmail=DataGenerator.randomEmail();
        sendText(createAccountPage.emailInput,generateRandomEmail);
        selectFromDropDown(createAccountPage.genderInput,"Male");
        selectFromDropDown(createAccountPage.TitlePrefix,"Mr.");
        selectFromDropDown(createAccountPage.maritalSt,"Married");
        clickOnElement(createAccountPage.createAccountBt);

        //Validate user navigate to Sing up your Account page and email address shows as expected.

        String actualEmail= getElementText(createAccountPage.EmailAddress);

        Assert.assertEquals(actualEmail,generateRandomEmail,"Email should display all the time");
        System.out.println(actualEmail);

    }
    /*
    Scenario 3) Create account with existing email address and validate error message as expected
     */
    @DataProvider(name = "existingCredentials")
    private String[][] existingCredentialProvider(){
        String[][]data={
                {"reza.safar1@gmail.com","Reza","Teacher","safari","12/15/1999","Account with email reza.safar1@gmail.com is exist"}
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

        // belongs to error message
       String actualErrorMessages= getElementText(createAccountPage.ErrorMessageExsitingAc);
       String deleteErrorText=actualErrorMessages.replace("ERROR","").trim();
       Assert.assertEquals(expectedErrorMessage,deleteErrorText);
    }

}
