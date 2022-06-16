package Pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(BasePage.class);

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
    }

    public WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
        element = driver.findElement(By.xpath(xpath));
        return element;
    }
    public WebElement findElementByPartTextLink(String text) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText(text)));
        element = driver.findElement(By.partialLinkText(text));
        return element;
    }
    public WebElement findElementByLinkText(String text) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(text)));
        element = driver.findElement(By.linkText(text));
        return element;
    }
    protected void clickElementByXpath(String xpath) {
        logger.info("Clicking element by xpath" + xpath);
        findElementByXpath(xpath).click();
    }

    protected void sendTextToElementByXpath(String xpath, String text) {
        findElementByXpath(xpath).sendKeys(text);
    }

    protected boolean elementExists(String xpath) {
        try {
            logger.info("Check element xpath" + xpath);
            driver.findElement(By.xpath(xpath));

            return true;
        } catch (Exception error) {

            return false;
        }
    }

    protected String getCurrentUrl() {

        return driver.getCurrentUrl();
    }

    public void takeScreenshot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
