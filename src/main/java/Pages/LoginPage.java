package Pages;

import Consts.Constants;

public class LoginPage extends BasePage {
    private static final String LOGIN_TITLE = "//h1[text()='Login']";
    private static final String LOGIN_BUTTON = "//input[@value='Sign In']";
    private static final String ERROR_MESSAGE = "//div[@class='shopify-challenge__container']/p";   //"//li[text()='Incorrect email or password.']";

    public boolean isLoginTitleVisible(){
        return elementExists(LOGIN_TITLE);
    }

    public void navigateToLoginPage(){
        driver.get(Constants.LOGIN_PAGE_URL);
    }
    public void clickLoginButton(){
        clickElementByXpath(LOGIN_BUTTON);
    }
    public boolean isErrorVisible(){
       boolean errorVisible = elementExists(ERROR_MESSAGE);
       return errorVisible;
    }
    public void sendPassword(){
        sendTextToElementByXpath("//input[@id='CustomerPassword']", "1234");
    }
    public void sendIncorrectEmail(){
        sendTextToElementByXpath("//input[@id='CustomerEmail']", "abcdefghij");
    }

}
