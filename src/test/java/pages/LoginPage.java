package pages;

import org.openqa.selenium.By;
import util.ElementUtil;

public class LoginPage {

    ElementUtil elementUtil = new ElementUtil();

    private final By emailTextBox = By.id("txtUserName");
    private final By emailTab = By.cssSelector("._2q4oJzGUsyLIOBhRdWWO9D");
    private final By loginButtonEmail = By.id("btnLogin");
    private final By loginButtonPassword = By.id("btnEmailSelect");
    private final By passwordTextbox = By.id("txtPassword");



    public void checkLoginTab(){elementUtil.checkElementVisible(emailTab);}

    public void clickEmailTextbox(){elementUtil.click(emailTextBox);}
    public void sendKeyEmailTextbox(String email){elementUtil.sendKey(emailTextBox, email);}

    public void clickLoginEmailButton(){elementUtil.click(loginButtonEmail);}

    public void clickLoginPasswordButton(){elementUtil.click(loginButtonPassword);}

    public void checkPasswordTextbox(){elementUtil.checkElementVisible(passwordTextbox);}

    public void sendkeyPasswordTextbox(String password){elementUtil.sendKey(passwordTextbox, password);}



}
