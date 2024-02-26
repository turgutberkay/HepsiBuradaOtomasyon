package util;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ElementUtil {

    WebDriver driver;
    WebDriverWait wait ;
    WebDriverWait wait2 ;
    Actions action;


    public ElementUtil() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        this.wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.action = new Actions(driver);
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void checkUrl(String url) {Assert.assertEquals(url,driver.getCurrentUrl());}

    public WebElement presenceElement(By key) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(key));
        return element;
    }
    public WebElement visibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement visibilityElement(By key) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(key));
    }

    public List<WebElement> presenceElements(By key) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
        return elements;
    }

    public void checkElementVisible(By key) {
        presenceElement(key);
        try {
            visibilityElement(key);
        }catch (Exception ignored){
            scrollToElement(presenceElement(key));
            visibilityElement(key);
        }
    }
    public void checkElementVisible(WebElement element) {
        try {
            visibilityElement(element);
        }catch (Exception ignored){
            scrollToElement(element);
            visibilityElement(element);;
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'})", element);
        }catch (Exception ignored){
            Assert.fail("Scroll couldn't be performed");
        }
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 750);");
    }

    public WebElement findElementClickableShort(By key) {
        try {
            WebElement element = wait2.until(ExpectedConditions.elementToBeClickable(key));
            return element;
        }catch (Exception ignored) {
            return null;
        }
    }
    public WebElement findElementClickableShort(WebElement element) {
        try {
            WebElement returnElement = wait2.until(ExpectedConditions.elementToBeClickable(element));
            return returnElement;
        }catch (Exception ignored) {
            return null;
        }
    }
    public void click(By key) {
        try {
            findElementClickableShort(key).click();
        }catch (Exception e){
            scrollToElement(presenceElement(key));
            wait.until(ExpectedConditions.elementToBeClickable(key)).click();
        }
    }
    public void click(WebElement element) {
        try {
            findElementClickableShort(element).click();
        }catch (Exception e){
            scrollToElement(element);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }

    public void clickElementWithTextFromElements(By key, String text) {
        boolean check = false;
        for(WebElement element : presenceElements(key)){
            if(element.getText().equals(text)){
                click(element);
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    public void sendKey(By key, String string) {
        try {
            WebElement element = presenceElement(key);
            element.sendKeys(string);
        } catch (Exception ignored) {
            Assert.fail("Element not writing");
        }
    }

    public String elementGetText(By by) {
        String text = null;
        try {
            presenceElement(by);
            text = driver.findElement(by).getText();
            return text;
        } catch (Exception ignored) {
            Assert.fail();
            return null;
        }
    }

    public WebElement getRandomElementFromElements(By by) {
        Random random = new Random();
        int randomNumber = random.nextInt(presenceElements(by).size());
        return presenceElements(by).get(randomNumber);
    }

    public WebElement getElementIndexFromElements(By by, Integer number) {
        return presenceElements(by).get(number);
    }

    public void equalsElementText(By key,String text) {
        presenceElement(key);
        Assert.assertEquals(elementGetText(key), text);
    }
    public void notEqualsElementText(By key,String text) {
        presenceElement(key);
        Assert.assertNotEquals(elementGetText(key), text);
    }

    public void checkElementNotEmpty(By key) {
        Assert.assertFalse(presenceElements(key).isEmpty());
    }

    public void switchToNewWindow() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }


}
