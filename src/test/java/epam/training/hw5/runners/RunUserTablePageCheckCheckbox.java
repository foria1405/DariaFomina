package epam.training.hw5.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/UserTablePageCheckCheckbox.feature"},
        glue = {"epam.training.hw5.steps", "epam.training.hw5.hooks"}
)
public class RunUserTablePageCheckCheckbox extends AbstractTestNGCucumberTests {
}
