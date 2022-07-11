import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/GoogleExample.feature",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/test-report.html",
                "json:target/cucumber-reports/test-report.json",
                "rerun:target/failed_scenarios.txt"
        }
)

/*
"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
 */

public class RunCukeTest {
}
