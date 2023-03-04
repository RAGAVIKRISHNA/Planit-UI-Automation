package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/java/resources/",
        glue = {"com.planit.shoptoys.stepDefs"},
        plugin = {"pretty","html:target/cucumber-report/cucumber.html", "json:target/cucumber-reports/cucumber.json", "junit:report//cucumber.xml"},
        dryRun =false,
        strict=true,
        monochrome =true
         
        )
public class TestRunner {
    
}