package pages;

import enums.UserEnum;
import interfaces.ISelector;
import org.openqa.selenium.By;
import utils.CommonUtils;

import static org.junit.Assert.assertTrue;

public class LoginPage extends CommonUtils{

    private static String baseURL = "https://the-internet.herokuapp.com";
    private static String login = "/login";

    public void navigateToLoginPage(){
        System.out.println("Navigating to the Login page...");
        navigateToURL(baseURL + login);
    }

    public void enterUserName(String user) {
        waitForElementToBeVisible(LoginPageEnum.USERNAME.selector());
        System.out.println("Entering username...\n");
        sendKeys(LoginPageEnum.USERNAME.selector(), user);
    }

    public void enterPassword(String password) {

        waitForElementToBeVisible(LoginPageEnum.PASSWORD.selector());
        System.out.println("Enter password...\n");
        sendKeys(LoginPageEnum.PASSWORD.selector(), password);
    }

    public void verifyDefaultElementsDisplay(){
        System.out.println("Verifying Page Elements display: ");


        assertTrue(getElement(LoginPageEnum.USERNAME.selector()).isDisplayed());
        assertTrue(getElement(LoginPageEnum.PASSWORD.selector()).isDisplayed());
        assertTrue(getElement(LoginPageEnum.LOGIN_BUTTON.selector()).isDisplayed());
    }

    public void logIntoPage(UserEnum user){

        String username = user.getUserName();
        String password = user.getPassword();

        verifyDefaultElementsDisplay();
        enterUserName(username);
        enterPassword(password);
        waitForElementToBeClickable((LoginPageEnum.LOGIN_BUTTON.selector()));
        click(LoginPageEnum.LOGIN_BUTTON.selector());

    }

    public enum LoginPageEnum implements ISelector {

        USERNAME("[name='username']"),
        PASSWORD("[name='password']"),
        LOGIN_BUTTON("[type='submit'][class='radius']");

        String id;

        private LoginPageEnum(String Id){
            this.id = Id;
        }

        public String getId(){
            return id;
        }

        public By selector() {
            return By.cssSelector(getId());
        }

        public LoginPageEnum[] getDefaultElements(){
            return new LoginPageEnum[] {USERNAME, PASSWORD, LOGIN_BUTTON};
        }
    }

}
