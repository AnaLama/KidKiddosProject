import Pages.ContactUsPage;
import Pages.LoginPage;
import Pages.MainPage;
import Utils.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainPageTests extends BaseTest {

    private static MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(MainPageTests.class);

    @BeforeAll

    public static void classSetup() {
        mainPage = new MainPage();
    }

    @BeforeEach

    public void beforeTestSetup() {
        mainPage.navigateToMainPage();
    }

    @Test
    public void testMainPageLoad() {
        boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenshot("mainPageLoad");

        Assertions.assertTrue(success);
    }

    @Test
    public void testContactUsButton() {
        logger.info("Contact us page open");
        ContactUsPage contactUsPage = mainPage.openContactUsPage();
        mainPage.takeScreenshot("testContactUsButton");
        boolean isLoaded = contactUsPage.isPageTitleVisible();

        Assertions.assertTrue(isLoaded);
    }

    @Test
    public void testLoginButton() {
        LoginPage loginPage = mainPage.openLoginPage();
        mainPage.takeScreenshot("testLoginButton");
        boolean isVisible = loginPage.isLoginTitleVisible();

        Assertions.assertTrue(isVisible);
    }
    @Test
    public void testBooksByLanguageDropDownMenu(){
        mainPage.openBooksByLangDropDownMenu();
        mainPage.findElementByLinkText("English Only").click();
        mainPage.findElementByXpath(
                "//a[@href='/collections/english-only/products/amandas-dream-childrens-picture-book-english-only']").click();

        Assertions.assertEquals("https://kidkiddos.com/collections/english-only/products/amandas-dream-childrens-picture-book-english-only",
                mainPage.checkURL());

        mainPage.findElementByXpath(
                "//div[@class='selector-wrapper js product-form__item']/select[@data-index='option1']/option[@value='Hardcover']").click();
        mainPage.findElementByXpath("//div[@class='product-form__item product-form__item--quantity']/input[@id='Quantity']").clear();
        mainPage.findElementByXpath("//div[@class='product-form__item product-form__item--quantity']/input[@id='Quantity']").sendKeys("5");
        mainPage.findElementByXpath("//button[@class='btn product-form__cart-submit']/span[@id='AddToCartText-product-template']").click();

        Assertions.assertEquals("https://kidkiddos.com/cart", mainPage.checkURL());
        Assertions.assertEquals("Printed book format: Hardcover", mainPage.findElementByXpath("//div[@class='cart__meta-text']").getText());
        Assertions.assertEquals("5", mainPage.getAttributeValue());

        mainPage.findElementByXpath("//input[@class='cart__qty-input']").clear();
        mainPage.findElementByXpath("//input[@class='cart__qty-input']").sendKeys("6");
        String subtotal5 = mainPage.checkSubtotal();
        mainPage.clickUpdateButton();
        Assertions.assertNotEquals(subtotal5, mainPage.checkSubtotal());
    }
}
