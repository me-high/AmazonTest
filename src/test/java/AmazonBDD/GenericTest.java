package AmazonBDD;
/**
 * Created by Mihai on 08.09.2014.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    //@Cucumber.Options(format = {"pretty", "html:target/cucumber-html-report", "json-pretty:target/cucumber-report.json"})
    @CucumberOptions(format = "pretty", features = "src/test/resources/AmazonBDD")
    //this is an empty class to run with. This needs to remain empty
    public class GenericTest
    {
    }
