package tek.tdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import tek.tdd.utilities.SeleniumUtilities;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage extends SeleniumUtilities {

    public AccountsPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/a[1]")
    public WebElement accountLink;
    /*
    Accounts
    Scenario 1)
    Navigate to Customer Service Portal with valid CSR credentials and navigate to Accounts verify
    5 row /page is default
     */

    public  void verifyAccountRows() {
        int rowCount = getDriver().findElements(By.xpath("//table[@class='chakra-table css-5605sr']//tr")).size();
        int colCount = getDriver().findElements(By.xpath("//table[@class='chakra-table css-5605sr']//th")).size();
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j <= colCount; j++) {
                String actualValue = getDriver().findElements(By.xpath("//*[@id='root']/div/div[3]/div/div/div/div/table/tbody/tr[" + i + "]/td[" + j + "]")).toString();
                if (actualValue.equals("Boat")) {
                    System.out.println(i + ":" + j);
                }
            }

        }
    }
    /*
    Scenario 2)
    Navigate to Customer Service Portal with valid CSR credentials and navigate to Accounts change
    show per page to 10, 25, 50 and validate table records per page according to selected show per
    page.
     */
    public void validateRecordsPerPages (){
        int showPerPage=getDriver().findElements(By.cssSelector(".chakra-select__wrapper >select>option")).size();
        List<String>names=new ArrayList<String>();

        for (int i=1;i<=showPerPage; i++){
            String showPerpageSelector=".chakra-select__wrapper >select>option:nth-child("+i+")";
            getDriver().findElement(By.cssSelector(showPerpageSelector)).click();
            List<WebElement>namesElements=getDriver().findElements(By.cssSelector(".chakra-table>tbody>tr>td:nth-child(1)"));

            for (WebElement namesElement:namesElements){
                names.add(namesElement.getText());
            }

            int totalNames=names.size();
            if (totalNames==10) {
                System.out.println("Total Number of Names : " + totalNames);
                String displayedCount = getDriver().findElement(By.xpath("//*[@id='root']/div/div[3]/div/div/div/div[2]/div/div/div[3]/select"))
                        .getText().split(" ")[2].replace("Show","");
                System.out.println("Total Number of Displayed Names " + displayedCount);
                Assert.assertEquals(displayedCount, String.valueOf(totalNames));
            }
            break;
        }

    }
}
