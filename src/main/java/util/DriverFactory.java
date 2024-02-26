package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static util.DriverConf.*;

public class DriverFactory {

    static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static WebDriver setDriver(String browser) {
        switch (browser){
            case "Chrome" :
                ChromeOptions chromeOptions = getDefaultChromeConf();
                driverThreadLocal.set(new ChromeDriver(chromeOptions));
                break;
            case "Firefox" :
                FirefoxOptions firefoxOptions = getDefaultFirefoxConf();
                driverThreadLocal.set(new FirefoxDriver(firefoxOptions));
                break;
            case "Edge" :
                EdgeOptions edgeOptions = getDefaultEdgeConf();
                driverThreadLocal.set(new EdgeDriver(edgeOptions));
                break;
            default:
                ChromeOptions chromeOption = getDefaultChromeConf();
                driverThreadLocal.set(new ChromeDriver(chromeOption));
                break;

        }
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }


}
