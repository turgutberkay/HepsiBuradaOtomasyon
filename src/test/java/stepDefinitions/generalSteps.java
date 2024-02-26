package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.LoginPage;

public class generalSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("User Logged In {string} {string}")
    public void userLoggedIn(String email, String password){
        homePage.checkHomePage();
        homePage.clickLoginOrSignUp();
        homePage.clickLoginButton();
        loginPage.checkLoginTab();
        loginPage.clickEmailTextbox();
        loginPage.sendKeyEmailTextbox(email);
        loginPage.clickLoginEmailButton();
        loginPage.checkPasswordTextbox();
        loginPage.sendkeyPasswordTextbox(password);
        loginPage.clickLoginPasswordButton();
        homePage.checkNotAccountText();
    }

}
