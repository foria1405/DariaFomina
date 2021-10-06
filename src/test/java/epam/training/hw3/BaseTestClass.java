package epam.training.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {

    protected WebDriver webDriver;
    protected SoftAssertions softAssertions;
    protected Configuration properties;
    private final String pathToProperties = "src/test/resources/properties/pageProperties.properties";

    @BeforeClass
    public void initialization() throws ConfigurationException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        properties =  new PropertiesConfiguration(pathToProperties);
        softAssertions = new SoftAssertions();
    }

    @AfterClass
    public void closeSession() {
        webDriver.quit();
    }
}
