package tests;

import base.DriverFactory;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import utils.DriverUtils;

import static enums.UserEnum.*;

public class LoginTest {

    @Test
    public void test_Login() {

        DriverFactory df = new DriverFactory(DriverUtils.getDriver());
        df.login.navigateToLoginPage();
        assertEquals(df.login.getHeaderText(), "Login Page", "The Login page did not display! (FAIL)");
        df.login.verifyDefaultElementsDisplay();
        df.login.logIntoPage(TOM_SMITH);
        df.secure.verifyDefaultElementsDisplay();
        assertEquals(df.secure.getHeaderText(), "Secure Area", "The Secure Area page did not display! (FAIL)");
        df.secure.logOutOfSecureArea();
        assertEquals(df.login.getHeaderText(), "Login Page", "The Login page did not display! (FAIL)");
    }

}

