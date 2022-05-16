package Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertEquals;

public class BBC1Tests {
    private final long DEFAULT_WAIT_TIME = 30;
    private final String FORM_MESSAGE = "Sorry for interruption, its just testing form :^)";

    private final String CORRECT_NAME = "Dmytro";
    private final String INCORRECT_EMAIL = "incorrectemail";
    private final String CORRECT_EMAIL = "gmailtestemail@gmail.com";
    private final String PLACE = "Ukraine, Kyiv";
    private final String TELEPHONE = "123123123123";
    private final String ERROR_EMPTY_STORY_MESSAGE_FIELD = "can't be blank";
    private final String ERROR_EMPTY_NAME_FIELD = "Name can't be blank";
    private final String ERROR_NOT_ACCEPTED_TERMS_OF_SERVICE = "must be accepted";
    private final String ERROR_INVALID_EMAIL = "Email address is invalid";
     private WebDriver driver;
    private WebDriverWait waiter;

    @BeforeTest
    public void profileSetUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testSetUp(){
        driver = new ChromeDriver();
        waiter = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 0)
    public void checkAddingStoryWithCorrectData() {
        driver.findElement(By.xpath("//nav[@class='orbit-header-links international']//span[text()='News']")).click();
        driver.findElement(By.xpath("//a[@class='nw-o-link']/span[contains(text(), 'Coronavirus')]")).click();
        driver.findElements(By.xpath("//span[contains(text(), 'Your Coronavirus')]")).get(0).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h3[contains(text(), 'share')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//h3[contains(text(), 'share')]")));
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Close']")));
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='embed-content-container']")));
        driver.findElement(By.xpath("//textarea[@class='text-input--long']")).click();
        driver.findElement(By.xpath("//textarea[@class='text-input--long']")).sendKeys(FORM_MESSAGE);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(CORRECT_NAME);
        driver.findElement(By.xpath("//input[@placeholder='Email address']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(CORRECT_EMAIL);
        driver.findElement(By.xpath("//input[@placeholder='Contact number ']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Contact number ']")).sendKeys(TELEPHONE);
        driver.findElement(By.xpath("//input[@placeholder='Location ']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Location ']")).sendKeys(PLACE);
        driver.findElement(By.xpath("//p[contains(text(), 'I accept')]")).click();
        driver.findElement(By.xpath("//button[@class='button']")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='section-header-group__section-subheader']//p")));

        assertEquals("Hey "+ CORRECT_NAME + ", thanks for asking your question: \"" + FORM_MESSAGE +"\"", driver.findElements(By.xpath("//div[@class='section-header-group__section-subheader']//p")).get(0).getText());
        assertEquals("If we're able to investigate it further, we'll email you at " + CORRECT_EMAIL + ".", driver.findElements(By.xpath("//div[@class='section-header-group__section-subheader']//p")).get(1).getText());
    }

    @Test(priority = 1)
    public void checkAddingStoryWithEmptyFields(){
        driver.findElement(By.xpath("//nav[@class='orbit-header-links international']//span[text()='News']")).click();
        driver.findElement(By.xpath("//a[@class='nw-o-link']/span[contains(text(), 'Coronavirus')]")).click();
        driver.findElements(By.xpath("//span[contains(text(), 'Your Coronavirus')]")).get(0).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h3[contains(text(), 'share')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//h3[contains(text(), 'share')]")));
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Close']")));
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='embed-content-container']")));
        driver.findElement(By.xpath("//button[@class='button']")).click();

        waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='input-error-message']")));
        assertEquals(ERROR_EMPTY_STORY_MESSAGE_FIELD, driver.findElements(By.xpath("//div[@class='input-error-message']")).get(0).getText());
        assertEquals(ERROR_EMPTY_NAME_FIELD, driver.findElements(By.xpath("//div[@class='input-error-message']")).get(1).getText());
        assertEquals(ERROR_NOT_ACCEPTED_TERMS_OF_SERVICE, driver.findElements(By.xpath("//div[@class='input-error-message']")).get(2).getText());
    }

    @Test(priority = 2)
    public void checkAddingStoryWithInvalidDataInEmailField(){
        driver.findElement(By.xpath("//nav[@class='orbit-header-links international']//span[text()='News']")).click();
        driver.findElement(By.xpath("//a[@class='nw-o-link']/span[contains(text(), 'Coronavirus')]")).click();
        driver.findElements(By.xpath("//span[contains(text(), 'Your Coronavirus')]")).get(0).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h3[contains(text(), 'share')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//h3[contains(text(), 'share')]")));
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Close']")));
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='embed-content-container']")));
        driver.findElement(By.xpath("//textarea[@class='text-input--long']")).click();
        driver.findElement(By.xpath("//textarea[@class='text-input--long']")).sendKeys(FORM_MESSAGE);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(CORRECT_NAME);
        driver.findElement(By.xpath("//input[@placeholder='Email address']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(INCORRECT_EMAIL);
        driver.findElement(By.xpath("//input[@placeholder='Contact number ']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Contact number ']")).sendKeys(TELEPHONE);
        driver.findElement(By.xpath("//input[@placeholder='Location ']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Location ']")).sendKeys(TELEPHONE);
        driver.findElement(By.xpath("//p[contains(text(), 'publish my')]")).click();
        driver.findElement(By.xpath("//p[contains(text(), 'I accept')]")).click();
        driver.findElement(By.xpath("//button[@class='button']")).click();

        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='input-error-message']")));

        assertEquals(ERROR_INVALID_EMAIL, driver.findElement(By.xpath("//div[@class='input-error-message']")).getText());
    }

}
