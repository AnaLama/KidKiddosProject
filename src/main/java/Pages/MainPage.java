package Pages;

import Consts.Constants;

public class MainPage extends BasePage {

    private static final String LOGO_IMG = "//img[@itemprop='logo']";
    private static final String CONTACT_US_BUTTON = "//a[text()='Contact us']";
    private static final String LOGIN_BUTTON = "//a[@href='/account/login']";
    private static final String BOOKS_BY_LANGUAGE_MENU ="//a[@aria-controls='SiteNavLabel-books-by-language']";
    private static final String UPDATE_BUTTON = "//input[@class='btn btn--secondary cart__update cart__update--large small--hide']";
    private static final String SUBTOTAL_FIELD =  "//div[@class='grid__item text-right small--text-center']/div/span[@class='cart__subtotal']";
    public void navigateToMainPage() {
        driver.get(Constants.BASE_URL);
    }

    public boolean isLogoVisible() {
        boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }

    public ContactUsPage openContactUsPage(){
        clickElementByXpath(CONTACT_US_BUTTON);

        return new ContactUsPage();
    }
    public LoginPage openLoginPage(){
        clickElementByXpath(LOGIN_BUTTON);

        return new LoginPage();
    }
    public void openBooksByLangDropDownMenu(){
        clickElementByXpath(BOOKS_BY_LANGUAGE_MENU);
    }
    public String checkURL(){
       return getCurrentUrl();
    }
    public String getAttributeValue(){
       return findElementByXpath("//input[@class='cart__qty-input']").getAttribute("value");
    }
    public void clickUpdateButton(){
        clickElementByXpath(UPDATE_BUTTON);
    }
    public String checkSubtotal(){
      return  findElementByXpath(SUBTOTAL_FIELD).getText();
    }
}
