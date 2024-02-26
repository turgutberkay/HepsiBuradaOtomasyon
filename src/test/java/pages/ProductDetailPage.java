package pages;

import org.openqa.selenium.By;
import util.ElementUtil;

public class ProductDetailPage {

    ElementUtil elementUtil = new ElementUtil();
    static boolean likeCheck = false;

    private final By productCarousel = By.id("productDetailsCarousel");
    private final By reviewTab = By.id("reviewsTabTrigger");
    private final By productViews = By.cssSelector(".hermes-ReviewCard-module-dY_oaYMIo0DJcUiSeaVW");
    private final By sortingModule = By.cssSelector(".hermes-Sort-module-VANnZ3_cDZVFx6SLhcdd");
    private final By sortingOption = By.cssSelector(".hermes-Sort-module-CWnJiGEufJWS8Y2TMNuF.hermes-Sort-module-F5wWWffLEvSW2rQuj0Pm");
    private final By likeButtonText = By.cssSelector(".customerAccount-Like-13gj2");
    private final By toastMessage = By.cssSelector(".hb-toast-text");


    public void switchToNewWindow() {elementUtil.switchToNewWindow();}

    public void checkProductDetailPage() {elementUtil.checkElementVisible(productCarousel);}

    public void clickReviewTab() {elementUtil.click(reviewTab);}

    public void checkProductReviews(){elementUtil.checkElementNotEmpty(productViews);}

    public void clickSortingModule(){
        //Burada sayfa asagı gittiginde dom ve ekran yenileniyor. Bu yuzden scrollToElement calısmıyor. Scroll down ile cozume ulastırdım.
        elementUtil.scrollDown();
        elementUtil.click(sortingModule);
    }

    public void checkSortingOptions(){
        elementUtil.checkElementVisible(sortingOption);
    }

    public void clickSortingOption(String option){elementUtil.clickElementWithTextFromElements(sortingOption, option);}

    public void clickLikeButtonIfNotClickedBefore(){

        if(elementUtil.elementGetText(likeButtonText).equals("Beğen")){
            elementUtil.click(likeButtonText);
            likeCheck = true;
        } else if (elementUtil.elementGetText(likeButtonText).equals("Beğendin")) {
            System.out.println("Urun zaten daha once begenilmis");
        }
    }

    public void ifNowLikeCheckMessage(String message){if(likeCheck){elementUtil.equalsElementText(toastMessage, message);}}

    public void clickLikeButton(){elementUtil.click(likeButtonText);}




}
