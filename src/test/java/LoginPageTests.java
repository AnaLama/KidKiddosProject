import Pages.LoginPage;
import Utils.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginPageTests extends BaseTest {
    private static LoginPage loginPage;

    @BeforeAll
    public static void classSetup(){
        loginPage = new LoginPage();
    }
    @BeforeEach
    public void beforeTestSetup(){
        loginPage.navigateToLoginPage();
    }
    @Test
    public void negativeTestLoginBlankFields (){
        loginPage.clickLoginButton();
        loginPage.takeScreenshot("Login Error message");
        boolean errorVisible = loginPage.isErrorVisible();

        Assertions.assertTrue(errorVisible);
    }
//@Test
//    public void testNegativeIncorrectValueEmail(){
//        loginPage.sendIncorrectEmail();
//        loginPage.sendPassword();
//        loginPage.clickLoginButton();
//        String s = loginPage.findElementByPartTextLink("missing an @").getText();
//         Assertions.assertEquals( "ss", s);
//}
}
