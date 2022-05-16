package Task4;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/testsFinalTask.feature",
        glue = "Task4/definitionsteps"
)
public class RunnerTests {
}
