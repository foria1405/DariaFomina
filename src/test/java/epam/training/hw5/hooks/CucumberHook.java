package epam.training.hw5.hooks;

import epam.training.hw5.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHook {

    @Before
    public void downloadAndSetUpWebDriver() throws ConfigurationException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String pathToProperties = "src/test/resources/properties/pageProperties.properties";
        TestContext.getInstance()
                .putObject("webDriver", webDriver)
                .putObject("properties", new PropertiesConfiguration(pathToProperties));
    }

    @After
    public void tearDownWebDriver() {
        WebDriver webDriver = TestContext.getInstance().getObject("webDriver");
        if (webDriver != null) {
            webDriver.quit();
        }
        TestContext.getInstance().clear();
    }
}
