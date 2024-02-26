package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverConf {

    public static ChromeOptions getDefaultChromeConf() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().clearResolutionCache();
        WebDriverManager.chromedriver().setup();
        return options;
    }

    public static FirefoxOptions getDefaultFirefoxConf() {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("dom.disable_open_during_load", true);
        options.addPreference("browser.infobar.show", false);
        WebDriverManager.firefoxdriver().clearDriverCache();
        WebDriverManager.firefoxdriver().clearResolutionCache();
        WebDriverManager.firefoxdriver().setup();
        return options;
    }

    public static EdgeOptions getDefaultEdgeConf() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        WebDriverManager.edgedriver().clearDriverCache();
        WebDriverManager.edgedriver().clearResolutionCache();
        WebDriverManager.edgedriver().setup();
        return options;
    }




}
