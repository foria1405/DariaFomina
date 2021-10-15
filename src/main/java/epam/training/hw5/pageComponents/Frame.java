package epam.training.hw5.pageComponents;

import epam.training.hw5.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Frame extends AbstractComponent {

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public Frame(HomePage parent) {
        super(parent.webDriver);
    }

    public WebElement getFrame() {
        return frame;
    }

    public boolean isFrameButtonDisplayed() {
        return frameButton.isDisplayed();
    }

    public boolean isFrameDisplayed() {
        return frame.isDisplayed();
    }

}
