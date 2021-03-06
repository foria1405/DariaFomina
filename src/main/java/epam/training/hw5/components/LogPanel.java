package epam.training.hw5.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@FindBy(css = "ul.logs")
public class LogPanel extends AbstractComponent {
    @FindBy(tagName = "li")
    private List<WebElement> logList;

    public LogPanel(WebDriver webDriver) {
        super(webDriver);
    }

    public String findLog(String logText) {
        return logList
                .stream()
                .map(WebElement::getText)
                .filter(log -> log.contains(logText))
                .findFirst()
                .toString();
    }
}
