import Pages.ContactUsPage;
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

    public static void classSetup (){
        mainPage = new MainPage();
    }

    @BeforeEach

    public void beforeTestSetup(){
        mainPage.navigateToMainPage();
    }

    @Test
    public void testMainPageLoad (){
        boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenshot("mainPageLoad");

        Assertions.assertTrue(success);
    }

    @Test
   public void testContactUsButton(){
        logger.info("Contact us page open");
       ContactUsPage contactUsPage = mainPage.openContactUsPage();
       mainPage.takeScreenshot("testContactUsButton");
       boolean isLoaded = contactUsPage.isPageTitleVisible();
       Assertions.assertTrue(isLoaded);
    }

}
