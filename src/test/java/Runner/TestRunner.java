package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/java/Features/"},
        glue={"Steps"},
        monochrome = true,
        tags={"@cleartrip,@automationpractice,@travel"},
        plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html"}
)
public class TestRunner {

}











