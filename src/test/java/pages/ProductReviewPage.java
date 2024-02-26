package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import util.ElementUtil;

public class ProductReviewPage {

    ElementUtil elementUtil = new ElementUtil();

    private final By product = By.cssSelector(".hermes-ProductRate-module-hiURqoYZp9s8M5iZQoAE.hermes-ProductRate-module-bTheIwG_WsWwJ6RYmyRN");
    private final By thumbsUpButton = By.cssSelector(".thumbsUp.hermes-ReviewCard-module-lOsa4wAwncdp3GgzpaaV");
    private final By thumbsDownButton = By.cssSelector(".thumbsDown.hermes-ReviewCard-module-hiS8vgAdxD2oeXanfvPg");
    private final By thankYouText = By.cssSelector(".hermes-ReviewCard-module-eFtSSTU4lYZLCnzHtzca");


    public void checkProductReviewPage(){
        elementUtil.checkElementVisible(product);
    }

    public void clickThumbsRandomReviews(String option, String number){
        if(option.equals("thumbsUp")){
            elementUtil.click(elementUtil.getElementIndexFromElements(thumbsUpButton, Integer.parseInt(number)-1));
        } else if (option.equals("thumbsDown")) {
            elementUtil.click(elementUtil.getElementIndexFromElements(thumbsDownButton,Integer.parseInt(number)-1));
        }else{
            Assert.fail("Lutfen thumbsUp veya thumpsDown degeri girin");
        }
    }

    public void checkThankYouText(String number){elementUtil.checkElementVisible(elementUtil.getElementIndexFromElements(thankYouText, Integer.parseInt(number)-1));}








}
