package AmazonBDD.Pages;//Author: Mihai Moraru

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class AmazonSearch {

    public WebDriver driver;
    Logger logger = LoggerFactory.getLogger(AmazonSearch.class);
    //    manipulates the results data table
    private List<AmazonResults> results = new ArrayList<AmazonResults>();

    ;//Android, Ipad, Iphone,

    //open specified browser
    public void chooseBrowser(Browsers browser) throws Exception {
        //instantiate a new browser based on the choice of browsers
//        Config config = new Config();
//        config.getBrowserType();
        switch (browser) {
            case Firefox: {
                driver = new FirefoxDriver();
                break;
            }
            case Chrome: {
                //WebDriver driver;
                //driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
                driver = new ChromeDriver();
                break;
            }
            case InternetExplorer: {
                driver = new InternetExplorerDriver();
                break;
            }
            case Safari: {
                driver = new SafariDriver();
                break;
            }
            //case Android:				{ driver = new AndroidDriver();			break; }
            //case Iphone:				{ driver = new IPhoneDriver();			break; }
            default: {
                throw new Exception();
            }
        }
        logger.debug("The chosen browser was " + browser);
        driver.navigate().to("http://amazon.co.uk");
        //logger.warn("this is warning log entry");
        //logger.error("this is a error log entry");
    }

    // enter searched product
    public void searchProduct(String product)
    {
        By byElement = By.id("twotabsearchtextbox");
        WebElement webElement = driver.findElement(byElement);
        Actions selAction = new Actions(driver);
        selAction.sendKeys(webElement, product).perform();
    }

    // click GO button to search in Amazon
    public void clickGoButton() {
        By byElement = By.className("nav-submit-input");//id("login");
        WebElement webElement = driver.findElement(byElement);
        Actions selAction = new Actions(driver);
        selAction.click(webElement).perform();
    }

    public void checkPageDisplayed(String page) {
        String title = null;    //the page title
        String url = null;        //the page url
        if (page.equalsIgnoreCase("search results")) {    //settings for the login page
            url = "=search-alias";
        }
        assertTrue(driver.getCurrentUrl().contains(url));
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void verifyFirstResults(DataTable dataTable) throws Exception {
        results = dataTable.asList(AmazonResults.class);

        for (int i = 1; i < results.size(); i++) {
            String expectedPrice = results.get(i - 1).getPrice();
//            By byElement = By.xpath("//*[@id='result_" + (results.get(i-1).getResultNo() - 1) + "']/ul[1]/li[1]/div/a/span");
            By byElement = By.id("result_" + (results.get(i - 1).getResultNo() - 1));
            WebElement webElement = driver.findElement(byElement);
            assertTrue("Result is incorrect. Expected" + expectedPrice + ". Actual: " + webElement.getText(), webElement.getText().contains(expectedPrice));
        }
    }

    public enum Browsers {Firefox, Chrome, InternetExplorer, Opera, Safari}

}
