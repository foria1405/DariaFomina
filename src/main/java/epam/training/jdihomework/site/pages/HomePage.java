package epam.training.jdihomework.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import epam.training.jdihomework.site.elements.Header;
import lombok.Getter;

@Url("/index.html")
@Title("Home page")
@Getter
public class HomePage extends WebPage {
    private Header header;
}
