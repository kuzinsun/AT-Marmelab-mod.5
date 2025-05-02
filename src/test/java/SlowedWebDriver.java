import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SlowedWebDriver {
    private static class SlowListener extends AbstractWebDriverEventListener {
        private final int delayMs;

        public SlowListener(int delayMs) {
            this.delayMs = delayMs;
        }

        private void pause() {
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        @Override
        public void beforeClickOn(WebElement element, WebDriver driver) {
            pause();
        }

        @Override
        public void afterClickOn(WebElement element, WebDriver driver) {
            pause();
        }

        @Override
        public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
            pause();
        }

        @Override
        public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
            pause();
        }

        @Override
        public void beforeNavigateTo(String url, WebDriver driver) {
            pause();
        }

        @Override
        public void afterNavigateTo(String url, WebDriver driver) {
            pause();
        }
    }

    public static WebDriver wrapDriver(WebDriver original, int delayMs) {
        EventFiringWebDriver wrappedDriver = new EventFiringWebDriver(original);
        wrappedDriver.register(new SlowListener(delayMs));
        return wrappedDriver;
    }
}