package pages;

import org.openqa.selenium.By;
import util.ElementUtil;

public class HomePage {

    ElementUtil elementUtil = new ElementUtil();

    private final By searchBox = By.cssSelector(".MORIA-voltran-body.voltran-body.SearchBoxOld");
    private final By searchBoxInput = By.cssSelector(".theme-IYtZzqYPto8PhOx3ku3c");
    private final By searchButton = By.cssSelector(".searchBoxOld-yDJzsIfi_S5gVgoapx6f");
    private final By acceptAlert = By.id("onetrust-accept-btn-handler");
    private final By loginOrSignUp = By.id("myAccount");
    private final By loginButton = By.id("login");
    private final By loginOrSignUpText = By.cssSelector("[data-test-id='account']");



    public void goToUrl(String url) {elementUtil.goToUrl(url);}

    public void acceptAlertHomePage(){elementUtil.click(acceptAlert);}

    public void checkHomePage(){elementUtil.checkUrl("https://www.hepsiburada.com/");}

    public void clickSearchBox(){elementUtil.click(searchBox);}

    public void sendKeySearchBox(String text){
        elementUtil.sendKey(searchBoxInput,text);
    }

    public void clickSearchButton(){
        elementUtil.click(searchButton);
    }

    public void clickLoginOrSignUp(){elementUtil.click(loginOrSignUp);}

    public void clickLoginButton(){elementUtil.click(loginButton);}

    public void checkNotAccountText(){elementUtil.notEqualsElementText(loginOrSignUpText, "Giriş Yap");}




}
