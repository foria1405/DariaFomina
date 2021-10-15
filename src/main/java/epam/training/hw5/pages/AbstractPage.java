package epam.training.hw5.pages;

import epam.training.hw5.pageComponents.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public WebDriver webDriver;

    private final Header header;

    public AbstractPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(webDriver);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public Header getHeader() {
        return header;
    }
}
