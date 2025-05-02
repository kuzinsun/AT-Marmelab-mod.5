import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomersPage {

    protected static WebDriver driver;

    private final By searchField = By.xpath("//input[@placeholder='Search']");
    //private final By customerCart = By.xpath("//div[contains(@class, 'MuiTypography-root MuiTypography-body2')]");

    public CustomersPage(WebDriver driver) {CustomersPage.driver = driver;}

    public CustomersPage search(String customer) {
        driver.findElement(searchField).sendKeys(customer);
        return this;
    }

    public CustomersPage clickCustomerCart(String getCustomerName, String getCustomerSurename) {
        WebElement customerCart = driver.findElement(By.xpath("//div[text()='" + getCustomerName + "' and text()='" + getCustomerSurename + "']"));
        customerCart.click();
        return this;
    }

    public CustomersPage clickSecondCustomerCart(String getCustomerName, String getCustomerSurename) {
        WebElement secondCustomerCart = driver.findElement(By.xpath("//div[text()='" + getCustomerName + "' and text()='" + getCustomerSurename + "']"));
        secondCustomerCart.click();
        return this;
    }

}
