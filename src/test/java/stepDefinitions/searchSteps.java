package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

public class searchSteps {

    SearchPage searchPage = new SearchPage();

    @Then("should see Not Empty Product List on the Search Page")
    public void shouldSeeNotEmptyProductListOnTheSearchPage(){searchPage.checkNotEmptyProductList();}

    @When("taps to Random Product on the Search Page")
    public void tapsToRandomProductOnTheSearchPage(){searchPage.clickRandomProduct();}
}
