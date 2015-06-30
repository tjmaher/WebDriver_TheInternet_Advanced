package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverUtils {

    public static  WebDriver _driver;

    public static WebDriver getDriver() {
        _driver = new FirefoxDriver();
        return _driver;
    }
}
