package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"refiSteps_cucumber"},
        tags = "@dataDriven_test",
        plugin = {"pretty", "summary", "json:target/Cucumber.json"},
        publish = true
)
public class TestRunner {
}
