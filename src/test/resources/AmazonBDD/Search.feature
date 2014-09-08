Feature: Testing for search functionality


	Scenario Outline: Search Product
		Given I want to use the browser Firefox
		When I type ipod in the search input field
		And I click the Go button
		Then I am on the search results page

    Scenario Outline: Search product and buy
        Given I want to use the browser [browser]
        When I type ipod in the search input field
        And I click the Go button
        Then I am on the search results page

		Examples:
				|	    browser	 |
				|	    Firefox	 |
				|	    Chrome       |
				|     InternetExplorer   |