package sky.framework.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( plugin ={"pretty", "html:target/cucumber", "junit:target/cucumber.xml"},
        features = "src/test/java/sky/framework/features",
        glue = {"sky.framework.stepdefinitions"}
)
public class RunTests {
}
