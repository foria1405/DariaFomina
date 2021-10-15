package epam.training.hw5.pageComponents;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Benefit extends AbstractComponent {

    @FindBy(css = "span[class=\"benefit-txt\"]")
    private List<WebElement> benefitTexts;

    public Benefit(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getBenefitTextsExtracted() {
        return benefitTexts
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
