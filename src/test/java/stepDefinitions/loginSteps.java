package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class loginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("should see Login Page")
    public void shouldSeeLoginPage() {
        loginPage.checkLoginTab();
    }


    @When("write to {string} Email Textbox on the Login Page")
    public void writeToEmailTextboxOnTheLoginPage(String arg0) {
        loginPage.clickEmailTextbox();
        loginPage.sendKeyEmailTextbox(arg0);
    }

    @When("taps to Login Button Email on the Login Page")
    public void tapsToLoginButtonEmailOnTheLoginPage(){loginPage.clickLoginEmailButton();}

    @When("taps to Login Button Password on the Login Page")
    public void tapsToLoginButtonPasswordOnTheLoginPage(){loginPage.clickLoginPasswordButton();}

    @Then("should see Password Textbox on the Login Page")
    public void shouldSeePasswordTextboxOnTheLoginPage() {
        loginPage.checkPasswordTextbox();
    }

    @When("write to {string} Password Textbox on the Login Page")
    public void writeToPasswordTextboxOnTheLoginPage(String arg0) {
        loginPage.sendkeyPasswordTextbox(arg0);
    }
}
