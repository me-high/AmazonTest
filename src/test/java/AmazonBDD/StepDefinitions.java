package AmazonBDD; /**
 * Created by Mihai on 11.10.2014.
 */

import AmazonBDD.Pages.AmazonSearch;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions extends GenericTest {

    AmazonSearch searchOnAmazon = new AmazonSearch();

    //our statement for choosing a browser to test in
    @Given("^I want to use the browser (.*)$")
    public void chooseBrowser(AmazonSearch.Browsers browser) throws Exception {
        searchOnAmazon.chooseBrowser(browser);
    }

    //type in searched product name
    @When("^I type (.*) in the search input field$")
    public void enterProductName(String product) throws Exception {
        searchOnAmazon.searchProduct(product);
    }

    //click the Go button
    @When("^I click the Go button$")
    public void clickGo() throws Exception {
        searchOnAmazon.clickGoButton();
    }

    //check the page we are on
    @Then("^I am on the (.*) page$")
    public void checkPage(String page) throws Exception {
        searchOnAmazon.checkPageDisplayed(page);
    }

    @Then("^I verify the price for first 5 results")
    public void verifyFirstResults(DataTable results) throws Exception {
        searchOnAmazon.verifyFirstResults(results);
    }

    //close the browser
    @After
    public void closeBrowser() throws Exception {
        searchOnAmazon.closeBrowser();
    }

}