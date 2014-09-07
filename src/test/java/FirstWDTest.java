//Author: Mihai Moraru

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstWDTest {
    @Test
    public void startWebDriver() {

        //TODO: read url from configuration file
        String testUrl = "http://amazon.co.uk";
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to(testUrl);
        Assert.assertTrue("Expected: title should contain Amazon word. Actual: " + driver.getTitle(),
                driver.getTitle().contains("Amazon"));

        driver.close();

    }
}
