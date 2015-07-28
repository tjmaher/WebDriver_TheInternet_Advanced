package base;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SecureArea;

public class DriverFactory {

    public LoginPage login;
    public SecureArea secure;

    public DriverFactory(WebDriver driver){

        this.login = new LoginPage();
        this.secure = new SecureArea();
    }

}
