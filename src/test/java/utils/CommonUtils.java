package utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import java.util.List;

// Code written by James Moore @ Fitbit. Selections placed here by T.J. Maher.  

public abstract class CommonUtils {

    private static int timeout = 10;

    public CommonUtils() {
        _driver = DriverUtils.getDriver();
    }

    public static WebDriver _driver;
//    public WebDriver _driver;
    public WebDriverWait wait;
    public Actions actions;
    public Select select;

    public By getCSS(String Selector) {
        return By.cssSelector(Selector);
    }

    public By getXPATH(String Selector) {
        return By.xpath(Selector);
    }


    public By getId(String Selector) {
        return By.id(Selector);
    }

    public By getLinkText(String Selector) {
        return By.linkText(Selector);
    }

    public void navigateToURL(String URL) {
        System.out.println("Navigating to: " + URL);
        System.out.println("Thread id = " + Thread.currentThread().getId());

        try {
            _driver.navigate().to(URL);
        } catch (Exception e) {
            System.out.println("URL did not load: " + URL);
            throw new TestException("URL did not load");
        }
    }

    public String getPageTitle() {
        try {
            System.out.print(String.format("The title of the page is: %s\n\n", _driver.getTitle()));
            return _driver.getTitle();
        } catch (Exception e) {
            throw new TestException(String.format("Current page title is: %s", _driver.getTitle()));
        }
    }

    public WebElement getElement(By selector) {
        try {
            return _driver.findElement(selector);
        } catch (Exception e) {
            System.out.println(String.format("Element %s does not exist - proceeding", selector));
        }
        return null;
    }

    public String getElementText(By selector){
        waitForElementToBeVisible(selector);
        try{
            return StringUtils.trim(_driver.findElement(selector).getText());
        }catch (Exception e){
            System.out.println(String.format("Element %s does not exist - proceeding", selector));
        }
        return null;
    }

    public void sendKeys(By selector, String value) {
        WebElement element = getElement(selector);
        clearField(element);
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, selector.toString()));
        }
    }

    public void clearField(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
        }
    }

    public void click(By selector) {
        WebElement element = getElement(selector);
        waitForElementToBeClickable(selector);
        try {
            element.click();
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", selector));
        }
    }

    public void waitForElementToBeClickable(By selector ) {
        try {
            wait = new WebDriverWait(_driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
        } catch (Exception e) {
            throw new TestException("The following element is not clickable: " + selector);
        }
    }

    public void waitForElementToBeVisible(By selector) {
        try {
            wait = new WebDriverWait(_driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("The following element was not visible within [%s] seconds: %s ", "10".toString(), selector));
        }
    }

    public void waitForElementToDisappear(By selector) {
        System.out.println("Waiting for element to disappear: " + selector);
        try {
            wait = new WebDriverWait(_driver, 10);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
        } catch (Exception e) {
            System.out.println("Exception caught in waitForElementToDisappear:\n" + e.toString());
            throw new TestException(String.format("Element did not disappear: [%s]", selector.toString()));
        }
    }

    public void selectOption(By selector, Object value) {
        WebElement element = getElement(selector);
        List<WebElement> options = element.findElements(getTagName("option"));
        select = new Select(element);
        try {
            for (WebElement option : options) {
                if (option.isDisplayed()) {
                    if (value instanceof String) {
                        select.selectByValue((String) value);
                        break;
                    } else if (value instanceof Integer) {
                        select.selectByIndex((Integer) value);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public By getTagName(String Selector) {
        return By.tagName(Selector);
    }
}
