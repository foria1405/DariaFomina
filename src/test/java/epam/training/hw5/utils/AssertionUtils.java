package epam.training.hw5.utils;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

public class AssertionUtils {

    public static void assertNumberAndVisibilityElements(List<WebElement> elements, int expectedSize) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(elements.size()).isEqualTo(expectedSize);
        elements.forEach(element -> softAssertions.assertThat(element.isDisplayed()).isTrue());
        softAssertions.assertAll();
    }
}
