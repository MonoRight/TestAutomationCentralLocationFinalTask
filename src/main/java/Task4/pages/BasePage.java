package Task4.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    @FindBy(xpath = closePopUpWindowButtonXPath)
    protected WebElement closePopUpWindowButton;
    protected final String closePopUpWindowButtonXPath = "//button[@aria-label='Close']";

    WebDriver driver;
    Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForAjaxToComplete(long timeToWait) {
        new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0;"));
    }

    public WebElement waitVisibilityOfElement(long timeToWait, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitVisibilityOfElementLocated(long timeToWait, String webElementXPathLocator){
        new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementXPathLocator)));
    }

    public void waitVisibilityOfAllElementsLocatedBy(long timeToWait, String webElementXPathLocator){
        new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(webElementXPathLocator)));
    }

    public void moveToElementWithWait(WebElement webElement, long waitTime){
        actions.moveToElement(waitVisibilityOfElement(waitTime, webElement)).perform();
    }

    public void scrollToElement(WebElement webElement){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void clickTheWebElement(WebElement webElement){
        webElement.click();
    }
    public void clickTheWebElementByJS(WebElement webElement){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }

    public void enterInput(WebElement webElement, String message){
        webElement.sendKeys(message);
    }

    public WebElement getClosePopUpWindowButton(){
        return closePopUpWindowButton;
    }

    public String getClosePopUpWindowButtonXPath(){
        return closePopUpWindowButtonXPath;
    }

    public boolean webElementIsClickable(long timeToWait, WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
        try{
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        }catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean webElementIsDisplayed(WebElement webElement){
        return webElement.isDisplayed();
    }

}
