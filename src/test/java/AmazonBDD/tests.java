package AmazonBDD; /**
 * Created by Mihai on 08.09.2014.
 */
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class tests {
    //these are the different browsers we are willing to run against
    public enum Browsers		{ Firefox, Chrome, InternetExplorer, Opera, Safari };//Android, Ipad, Iphone,
    //this hashmap will keep our users that are active in the system
    //private HashMap<String,String> 		users = new HashMap<String,String>();
    //this is our selenium webdriver controlling our browsers
    private WebDriver		driver;

    @Before		//any steps we want to perform before we start our tests
    public void setup() {
        //initializing our system by adding our users
        //users.put("testuser1","testuser1");
        //users.put("testuser2","testuser2");
        //users.put("testuser3","testuser3");
        //startWebDriver();
    }

    @After		//any steps we want to perform after our tests
    public void cleanUp() {
        //close our browser, and finalize our driver instance
        driver.quit();
    }

    //our statement for choosing a browser to test in
    @Given("^I want to use the browser (.*)$")
    public void chooseBrowser(Browsers browser) throws Exception {
        //instantiate a new browser based on the choice of browsers
        switch ( browser ) {
            case Firefox:				{ driver = new FirefoxDriver(); 		break; }
            case Chrome:				{ driver = new ChromeDriver();			break; }
            case InternetExplorer:		{ driver = new InternetExplorerDriver(); 	break; }
            //case Android:				{ driver = new AndroidDriver();			break; }
            //case Iphone:				{ driver = new IPhoneDriver();			break; }
            case Safari:				{ driver = new SafariDriver();			break; }
            default:				{ throw new Exception();	}
        }
        //open our test site's URL
        driver.get( "http://amazon.co.uk" );
    }

    /////////////////////
    ////// SEARCH ///////
    /////////////////////

    //type in searched product name
    @When("^I type (.*) in the search input field$")
    public void enterProductName(String product) throws Exception {
        //webdrivers select element by id functionality
        By byElement = By.id("twotabsearchtextbox");
        //locate our element
        WebElement webElement = driver.findElement( byElement );
        //setup an action
        Actions selAction = new Actions(driver);
        //send keys to the element selected
        selAction.sendKeys( webElement, product ).perform();
    }

    //click the Go button
    @When("^I click the Go button$")
    public void clickGo() throws Exception {
        //webdrivers select element by id functionality
        By byElement = By.className("nav-submit-input");//id("login");
        //locate our element
        WebElement webElement = driver.findElement( byElement );
        //setup an action
        Actions selAction = new Actions(driver);
        //click the element selected
        selAction.click( webElement ).perform();
    }

    //check the page we are on
    @Then("^I am on the (.*) page$")
    public void checkPage(String page) throws Exception {
        String title = null;	//the page title
        String url = null;		//the page url
        if ( page.equalsIgnoreCase( "search" ) ) {	//settings for the login page
            //title = "Login To Cosmic Comics";
            url = "=search-alias";
        }
        //ensure we have the expected title
        //assertEquals( title, driver.getTitle() );
        //ensure we are on the correct page
        assertTrue( driver.getCurrentUrl().contains(url) );
    }
}