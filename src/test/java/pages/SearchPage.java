package pages;

import org.openqa.selenium.By;
import util.ElementUtil;


public class SearchPage {

    ElementUtil elementUtil = new ElementUtil();

    private final By productName = By.cssSelector("[data-test-id='product-card-name']");


    public void checkNotEmptyProductList() {elementUtil.checkElementNotEmpty(productName);}

    public void clickRandomProduct(){elementUtil.click(elementUtil.getRandomElementFromElements(productName));}



}
