import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import utils.DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:report/cucumber-report.html")
public class RunCucumberTest {

    @BeforeAll
    public static void beforeAll()
    {
        WebDriverManager.firefoxdriver().setup();
    }

    @After
    public void after(Scenario scenario) {
        DriverFactory.quitDriver();
    }
}
