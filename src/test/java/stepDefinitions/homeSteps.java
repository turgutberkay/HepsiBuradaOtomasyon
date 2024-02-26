package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class homeSteps {

    HomePage homePage = new HomePage();

    @Given("Go To Url {string}")
    public void goToUrl(String url) throws InterruptedException {
        //Thread.sleep kullanma sebebim acceptAlert sonrası sayfanın refresh atması. Bu yenilemeyi en dogru bu sekilde bekliyoruz
        homePage.goToUrl(url);
        homePage.acceptAlertHomePage();
        Thread.sleep(4000);
    }


    @Then("should see Home Page")
    public void shouldSeeHomePage() {homePage.checkHomePage();}


    @When("write to {string} SearchBox on the Home Page")
    public void writeToSearchBoxOnTheHomePage(String text){
        homePage.clickSearchBox();
        homePage.sendKeySearchBox(text);
    }


    @When("taps to Search Button on the Home Page")
    public void tapsToSearchButtonOnTheHomePage() {
        homePage.clickSearchButton();
    }


    @When("taps to Login Button on the Home Page")
    public void tapsToLoginButtonOnTheHomePage() {
        homePage.clickLoginOrSignUp();
        homePage.clickLoginButton();
    }

    @Then("should see Logged In Home Page")
    public void shouldSeeLoggedInHomePage() {
        homePage.checkNotAccountText();
    }
}
