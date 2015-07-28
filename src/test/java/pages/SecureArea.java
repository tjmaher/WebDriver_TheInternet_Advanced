package pages;

import interfaces.ISelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

import static org.junit.Assert.assertTrue;

public class SecureArea extends CommonUtils{

    public void verifyDefaultElementsDisplay(){
        System.out.println("SECURE_AREA: Checking if the page elements display correctly.");
        assertTrue(getElement(SecureAreaEnum.LOGOUT_BUTTON.selector()).isDisplayed());
    }

    public void logOutOfSecureArea(){
        System.out.println("SECURE_AREA: Logging out of Secure Area.");
        waitForElementToBeClickable((SecureAreaEnum.LOGOUT_BUTTON.selector()));
        click(SecureAreaEnum.LOGOUT_BUTTON.selector());
    }

    public String getHeaderText(){

        System.out.println("SECURE_AREA: Header is: " + getElementText(SecureAreaEnum.HEADER.selector()));
        return getElementText(SecureAreaEnum.HEADER.selector());

    }
    public enum SecureAreaEnum implements ISelector {

        HEADER("h2"),
        LOGOUT_BUTTON("[href='/logout']");

        String id;

        private SecureAreaEnum(String Id){
            this.id = Id;
        }

        public String getId(){
            return id;
        }

        public By selector() {
            return By.cssSelector(getId());
        }

        public SecureAreaEnum[] getDefaultElements(){
            return new SecureAreaEnum[] {
                    LOGOUT_BUTTON};
        }
    }

}