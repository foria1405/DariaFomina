package epam.training.jdihomework.site.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import epam.training.jdihomework.site.elements.Header;
import epam.training.jdihomework.site.elements.MetalColorsForm;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;


@Url("/metals-colors.html")
@Title("Metal and Colors")

public class MetalColorsPage extends WebPage {

    @Getter
    private Header header;

    @Getter
    private MetalColorsForm metalsColorsForm;

    @FindBy(css = "ul[class=\"panel-body-list results\"]>li")
    public WebList results;

    public List<String> getResultAsListString() {
        return this.getResults()
                .stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
}
