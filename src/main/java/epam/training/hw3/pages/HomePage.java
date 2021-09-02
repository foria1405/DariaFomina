package epam.training.hw3.pages;

import epam.training.hw3.components.*;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    private final Benefit benefit = new Benefit(webDriver);
    private final Frame frame = new Frame(this);

    public HomePage(WebDriver webDriver, String url) {
        super(webDriver);
        webDriver.get(url);
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public Frame getFrame() {
        return frame;
    }

    public Frame switchToFrame() {
        webDriver.switchTo().frame(frame.getFrame());
        return new Frame(this);
    }
}
