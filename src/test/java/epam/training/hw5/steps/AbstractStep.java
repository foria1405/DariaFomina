package epam.training.hw5.steps;

import epam.training.hw5.context.TestContext;
import epam.training.hw5.pages.DifferentElementsPage;
import epam.training.hw5.pages.HomePage;
import epam.training.hw5.pages.UserTablePage;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected WebDriver webDriver;

    protected PropertiesConfiguration properties;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public AbstractStep() {
        webDriver = TestContext.getInstance().getObject("webDriver");
        properties = TestContext.getInstance().getObject("properties");

        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        userTablePage = new UserTablePage(webDriver);
    }
}
