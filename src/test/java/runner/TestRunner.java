package runner;


import org.junit.platform.suite.api.*;
import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
//@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@IncludeTags("FirstTest.java")
@ConfigurationParameters({
            @ConfigurationParameter(key=GLUE_PROPERTY_NAME,value = "step_definitions"),
            @ConfigurationParameter(key=PLUGIN_PROPERTY_NAME,value = "pretty"),
              @ConfigurationParameter(key=PLUGIN_PROPERTY_NAME,value = "html:target/report.html"),

})
public class TestRunner {

}
