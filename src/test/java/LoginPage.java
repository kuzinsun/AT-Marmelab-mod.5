import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String username = ConfigLoader.getProperty("username");
    private final String password = ConfigLoader.getProperty("password");

    private final By usernameField = By.xpath("//input[@id=':r0:']");
    private final By passwordField = By.xpath("//input[@id=':r2:']");

    public LoginPage login() {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordField).sendKeys(Keys.ENTER);
        return this;
    }

}
