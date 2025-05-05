import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class OrdersPage {

    protected static WebDriver driver;

    protected WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, 30) // 10 секунд
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private final By deliveredTab = By.xpath("//span[text()='delivered']");
    private final By checkboxList = By.xpath("   //input[contains(@class, 'PrivateSwitchBase') and @type='checkbox']");
    private final By checkboxClickResult = By.xpath("//h6[text()='3 items selected']");

    public OrdersPage(WebDriver driver) {OrdersPage.driver = driver;}

    public OrdersPage clickDeliveredTab() {
        waitForElement(deliveredTab);
        driver.findElement(deliveredTab).click();
        return this;
    }

    public OrdersPage clickFirstThreeCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(checkboxList);
        for(int i = 1; i < 4 && i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
    return this;
    }

    public OrdersPage checkCheckboxClickResult() {
        waitForElement(checkboxClickResult);
        boolean result = driver.findElement(checkboxClickResult).isDisplayed();
        assertTrue("Выбрано 3 чекбокса, сообщение отображается", result);
        return this;
    }
}