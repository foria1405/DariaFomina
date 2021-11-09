package epam.training.jdihomework.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import epam.training.jdihomework.site.pages.HomePage;
import epam.training.jdihomework.site.pages.MetalColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light")
public class JdiLightSite {

    public static HomePage homePage;
    public static MetalColorsPage metalsColorsPage;
}
