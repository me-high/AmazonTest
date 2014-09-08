package AmazonBDD;
/**
 * Created by Mihai on 08.09.2014.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(format = "pretty", features = "src/test/resources/AmazonBDD")
//    @Cucumber.Options(format = {"pretty", "html:target/cucumber-html-report", "json-pretty:target/cucumber-report.json"})

    public class GenericTest
    {
    }
