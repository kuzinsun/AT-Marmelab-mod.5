import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InvoicesPage {
    private final WebDriver driver;

    public InvoicesPage(WebDriver driver) {this.driver = driver;}

    private final By dateGte = By.xpath("//input[@name='date_gte']");
    private final By dateLte = By.xpath("//input[@name='date_lte']");
    private final By expandButton = By.xpath("//div[@role='button']");
    private final By customer = By.xpath("//div[contains(@class, 'MuiTypography-root MuiTypography-body')]");//MuiTypography-root MuiTypography-body2 css-4prify
    private final By addFilter = By.xpath("//button[@aria-label='Add filter']");
    private final By chooseFilterType = By.xpath("//li[@data-key='customer_id']");
    private final By sendCustomer = By.xpath("//input[@role='combobox']");
    private final By changeAddressCheck = By.xpath("//p[text()='Groove street']");

    protected WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, 30) // 10 секунд
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public InvoicesPage inputDateGte() {
        String formattedDate = ("01012024").replaceAll("(\\d{2})(\\d{2})(\\d{4})", "$3-$2-$1");
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1];", driver.findElement(dateGte), formattedDate
        );
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].dispatchEvent(new Event('change'));", driver.findElement(dateGte)
        );
        return this;
    }

    public InvoicesPage inputDateLte() {
        String formattedDate = ("01082025").replaceAll("(\\d{2})(\\d{2})(\\d{4})", "$3-$2-$1");
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1];", driver.findElement(dateLte), formattedDate
        );
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].dispatchEvent(new Event('change'));", driver.findElement(dateLte)
        );
        return this;
    }

    public InvoicesPage clickExpandButton() {
        driver.findElement(expandButton).click();
        return this;
    }

    public String[] customer() {
        String actualText = driver.findElement(customer).getText();
        boolean containsText = actualText.contains("Korey Mohr");
        assertFalse("Клиент в первых заказах не Korey Mohr", containsText);
        String[] parts = actualText.split("\\s+", 3);
        return parts;
    }

    public InvoicesPage clickAddFilter() {
        driver.findElement(addFilter).click();
        return this;
    }

    public InvoicesPage clickChooseFilterType() {
        driver.findElement(chooseFilterType).click();
        return this;
    }

    public InvoicesPage sendCustomer(String customerName) {
        driver.findElement(sendCustomer).sendKeys(customerName);
        driver.findElement(sendCustomer).sendKeys(Keys.ENTER);;
        return this;
    }

    public InvoicesPage changeAddressCheck() {
        waitForElement(changeAddressCheck);
        assertTrue(driver.findElement(changeAddressCheck).isDisplayed());
        return this;
    }

    public InvoicesPage checkOldAddressRevert(String oldAddress) {
        WebElement check = driver.findElement(By.xpath("//p[text()='" + oldAddress + "']"));
        assertTrue(check.isDisplayed());
        return this;
    }

}
