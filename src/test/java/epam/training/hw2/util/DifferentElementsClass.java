package epam.training.hw2.util;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Radio;

public class DifferentElementsClass {
    private static final By inputInLabelLocator = By.tagName("input");

    public WebElement getCheckBox(List<WebElement> checkBoxList, String name) {
        return checkBoxList
                .stream()
                .filter(x -> x.getText().contains(name))
                .findFirst()
                .map(webElement -> webElement.findElement(inputInLabelLocator))
                .map(CheckBox::new)
                .orElse(null);
    }

    public WebElement getRadio(List<WebElement> radioList, String name) {
        return radioList
                .stream()
                .filter(x -> x.getText().contains(name))
                .findFirst()
                .map(webElement -> webElement.findElement(inputInLabelLocator))
                .map(Radio::new)
                .orElse(null);
    }

    public Select getDropDown(List<WebElement> radioList, String name) {
        Select dropDownButton = new Select(radioList.get(0));
        dropDownButton.selectByVisibleText(name);
        return dropDownButton;
    }
}
