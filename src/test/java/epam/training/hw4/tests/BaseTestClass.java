package epam.training.hw4.tests;

import epam.training.hw4.steps.ActionStep;
import epam.training.hw4.steps.AssertionStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {
    protected WebDriver webDriver;
    protected Configuration properties;
    private final String pathToProperties = "src/test/resources/properties/pageProperties.properties";
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeClass (description = "Set up WebDriver. Create properties, actionStep, assertionStep objects")
    public void initialization(ITestContext testContext) throws ConfigurationException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        properties =  new PropertiesConfiguration(pathToProperties);
        actionStep = new ActionStep(webDriver);
        assertionStep = new AssertionStep(webDriver);
        testContext.setAttribute("webDriver", webDriver);
    }

    @AfterClass
    public void closeSession() {
        webDriver.quit();
    }
}
