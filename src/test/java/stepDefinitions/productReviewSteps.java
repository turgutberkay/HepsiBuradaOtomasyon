package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductReviewPage;

public class productReviewSteps {

    ProductReviewPage productReviewPage = new ProductReviewPage();

    @Then("should see Product Review Page")
    public void shouldSeeProductReviewPage() {
        productReviewPage.checkProductReviewPage();
    }

    @When("taps to {string} thumbs from {string} Review on the Product Review Page")
    public void tapsToThumbsFromReviewOnTheProductReviewPage(String arg0, String arg1) {productReviewPage.clickThumbsRandomReviews(arg0,arg1);}

    @Then("should see {string} Thank You Text from Review on the Product Review Page")
    public void shouldSeeThankYouTextOnTheProductReviewPage(String number) {productReviewPage.checkThankYouText(number);}
}
