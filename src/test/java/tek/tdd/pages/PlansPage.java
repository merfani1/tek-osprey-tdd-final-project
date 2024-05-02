package tek.tdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import tek.tdd.utilities.SeleniumUtilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PlansPage extends SeleniumUtilities {

    public PlansPage(){
        PageFactory.initElements(getDriver(),this);

    }
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/a[2]")
    public WebElement PlansLink;

    @FindBy(xpath ="//table[@class='chakra-table css-5605sr']//tr")
    public WebElement rowOfTable;

   @FindBy(xpath = "//table[@class='chakra-table css-5605sr']//th")
    public WebElement columnOfTable;

   public  void countRowAndColumn(){
       int rowCount=getDriver().findElements(By.xpath("//table[@class='chakra-table css-5605sr']//tr")).size();
       int colCount=getDriver().findElements(By.xpath("//table[@class='chakra-table css-5605sr']//th")).size();
       for (int i=1; i<rowCount;i++){
           for (int j=1;j<=colCount;j++){
               String actualValue=getDriver().findElements(By.xpath("//*[@id='root']/div/div[3]/div/div/div/div/table/tbody/tr["+i+"]/td["+j+"]")).toString();
               if (actualValue.equals("Boat")){
                   System.out.println(i+":"+j);
               }
           }

       }
   }
   /*
   Scenario 2)
    Navigate to Customer Service Portal with valid CSR credentials and navigate to Plans Page. Then
    validate Create Date is todays date in (EST Time zone) and Date Expire is a day after (EST Time
    Zone)
    */
    public void validateCreateDate() {
        // Get today's date in EST time zone
        DateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        Date today = new Date();
        String expectedCreateDate = dateFormat.format(today);

        // Get actual Create Date value from the page
        WebElement createDateElement = getDriver().findElement(By.xpath("//*[@id='root']/div/div[3]/div/div/div/div/table/tbody/tr[2]/td[4]"));
        String actualCreateDate = createDateElement.getText();
        // Parse the input date string into LocalDate object
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDate date = LocalDate.parse(actualCreateDate, inputFormatter);

        // Format the LocalDate object into "MM/dd/yyyy" format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
        String actualFormattedDate = date.format(outputFormatter);

        // Validate Create Date
        Assert.assertEquals(actualFormattedDate, expectedCreateDate);
    }
    public void validateExpireDatePlan() throws InterruptedException, ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();


            // Parse the input date string
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
            Date date = inputDateFormat.parse(String.valueOf(tomorrow));

            // Format the date into "MMMM dd, yyyy" format
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            String expiredFormattedDate = outputDateFormat.format(date);


            // Get actual Date Expire value from the page
            Thread.sleep(2000);
            WebElement dateExpireElement = getDriver().findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div/table/tbody/tr[1]/td[5]"));
            String actualDateExpire = dateExpireElement.getText();


            // Validate Date Expire
            Assert.assertEquals(actualDateExpire, expiredFormattedDate);


    }


}
