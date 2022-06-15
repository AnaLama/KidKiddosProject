package Pages;

import Consts.Constants;

public class MainPage extends BasePage {

    private static final String LOGO_IMG = "//img[@itemprop='logo']";
    private static final String CONTACT_US_BUTTON = "//a[text()='Contact us']";

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
}
