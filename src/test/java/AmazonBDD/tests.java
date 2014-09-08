package AmazonBDD; /**
 * Created by Mihai on 08.09.2014.
 */
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static junit.framework.Assert.assertTrue;

public class tests {
    SearchOnAmazon amazonSearch = new SearchOnAmazon();
//    @Before		//any steps we want to perform before we start our tests
//    public void setup() {
//        //initializing our system by adding our users
//        //users.put("testuser1","testuser1");
//        //users.put("testuser2","testuser2");
//        //users.put("testuser3","testuser3");
//        //startWebDriver();
//
//    }
//
//    @After		//any steps we want to perform after our tests
//    public void cleanUp() {
//        //close our browser, and finalize our driver instance
//        //driver.quit();
//    }

    //our statement for choosing a browser to test in
    @Given("^I want to use the browser (.*)$")
    public void chooseBrowser(SearchOnAmazon.Browsers browser) throws Exception {
        amazonSearch.chooseBrowser(browser);
    }

    //type in searched product name
    @When("^I type (.*) in the search input field$")
    public void enterProductName(String product) throws Exception {
        amazonSearch.searchProduct(product);
    }

    //click the Go button
    @When("^I click the Go button$")
    public void clickGo() throws Exception {
        amazonSearch.clickGoButton();
    }

    //check the page we are on
    @Then("^I am on the (.*) page$")
    public void checkPage(String page) throws Exception {
        amazonSearch.checkPageDisplayed(page);
    }
}