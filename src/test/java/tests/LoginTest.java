package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utils.DriverUtils;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

import static enums.UserEnum.*;

public class LoginTest {

    private static WebDriver driver;
    LoginPage login = new LoginPage();


    @BeforeClass
    public static void setup() {

        driver = DriverUtils.getFirefoxDriver();
    }

    @Test
    public void test_Login() {

        login.navigateToLoginPage();
        login.logIntoPage(TOM_SMITH);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
