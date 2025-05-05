import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {this.driver = driver;}

    private final By ordersLink = By.xpath("//a[@href='#/orders']");
    private final By invoicesLink = By.xpath("//a[@href='#/invoices']");
    private final By customersLink = By.xpath("//a[@href='#/customers' and text()='Customers']");

    public MainPage ordersLinkClick() {
        driver.findElement(ordersLink).click();
        return this;
    }

    public MainPage invoicesLinkClick() {
        driver.findElement(invoicesLink).click();
        return this;
    }

    public MainPage customersLinkClick() {
        driver.findElement(customersLink).click();
        return this;
    }

}
