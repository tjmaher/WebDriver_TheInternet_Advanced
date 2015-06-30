package tests;

import enums.PageHeaderEnum;
import enums.PageHeaderEnum.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

import org.junit.Test;
import pages.LoginPage;
import pages.LoginPage.LoginPageEnum;
import pages.SecureArea;
import utils.DriverUtils;

import static enums.UserEnum.*;

public class LoginTest {

    LoginPage login = new LoginPage();
    SecureArea secure = new SecureArea();


    @Test
    public void test_Login() {

        login.navigateToLoginPage();
        assertEquals(login.getHeaderText(), "Login Page", "The Login page did not display! (FAIL)");
        login.verifyDefaultElementsDisplay();
        login.logIntoPage(TOM_SMITH);
        secure.verifyDefaultElementsDisplay();
        assertEquals(secure.getHeaderText(), "Secure Area", "The Secure Area page did not display! (FAIL)");
        secure.logOutOfSecureArea();
    }

}
