package AmazonBDD; /**
 * Created by Mihai on 08.09.2014.
 */

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions extends GenericTest {
    SearchOnAmazon amazonSearch = new SearchOnAmazon();

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