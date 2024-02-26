package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductDetailPage;

public class productDetailSteps {

    ProductDetailPage productDetailPage = new ProductDetailPage();

    @When("should see Product Detail Page")
    public void shouldSeeProductDetailPage() {
        productDetailPage.switchToNewWindow();
        productDetailPage.checkProductDetailPage();
    }

    @When("taps to Review Tab on the Product Detail Page")
    public void tapsToReviewTabOnTheProductDetailPage(){productDetailPage.clickReviewTab();}

    @Then("should see Product Reviews on the Product Detail Page")
    public void shouldSeeProductReviewsOnTheProductDetailPage() {productDetailPage.checkProductReviews();}

    @When("taps to Sorting Module on the Product Detail Page")
    public void tapsToSortingModuleOnTheProductDetailPage(){productDetailPage.clickSortingModule();}

    @Then("should see Sorting Options on the Product Detail Page")
    public void shouldSeeSortingOptionsOnTheProductDetailPage() {
        productDetailPage.checkSortingOptions();
    }

    @When("taps to {string} on the Product Detail Page")
    public void tapsToOnTheProductDetailPage(String arg0) {
        productDetailPage.clickSortingOption(arg0);
    }

    @When("if not clicked before taps to Like Button on the Product Detail Page")
    public void ifNotClickedBeforeTapsToLikeButtonOnTheProductDetailPage() {productDetailPage.clickLikeButtonIfNotClickedBefore();}

    @Then("if like button now clicked should see message {string} on the Product Detail Page")
    public void ifLikeButtonNowClickedShouldSeeMessageOnTheProductDetailPage(String arg0) {productDetailPage.ifNowLikeCheckMessage(arg0);}

    @When("taps to Like Button on the Product Detail Page")
    public void tapsToLikeButtonOnTheProductDetailPage() {
        productDetailPage.clickLikeButton();
    }
}
