import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CustomerCartPage {

    protected static WebDriver driver;

    private final By address = By.xpath("//textarea[@name='address']");
    private final By saveButton = By.xpath("//button[@aria-label='Save']");
    private final By backupAddress = By.xpath("//textarea[@name='address']");

    public CustomerCartPage(WebDriver driver) {CustomerCartPage.driver = driver;}

    /*public CustomerCartPage clickAddress() {
        driver.findElement(address).click();
        return this;
    }*/

    public String getOldAddress() {
        return driver.findElement(address).getText();
    }

    public CustomerCartPage enterAddress() {
        driver.findElement(address).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(address).sendKeys("Groove street");
        return this;
    }

    public CustomerCartPage clickSaveButton() {
        driver.findElement(saveButton).click();
        return this;
    }

    public CustomerCartPage revertAddress(String oldAddress) {
        driver.findElement(backupAddress).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(backupAddress).sendKeys(oldAddress);
        return this;
    }

}
