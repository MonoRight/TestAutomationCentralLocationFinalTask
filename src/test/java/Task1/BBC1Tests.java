package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.rmi.UnexpectedException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class BBC1Tests {
    private final long DEFAULT_WAIT_TIME = 30;
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
    public void checkNameOfArticleInNewsSection(){
        driver.findElement(By.xpath("//nav[@class='orbit-header-links international']//span[text()='News']")).click();
        waiter.until(ExpectedConditions.visibilityOf(driver.findElements(By.xpath("//div[contains(@class, 'top-stories-primary')]//h3[contains(@class, 'promo-heading__title')]")).get(0)));

        assertEquals(driver.findElements(By.xpath("//div[contains(@class, 'top-stories-primary')]//h3[contains(@class, 'promo-heading__title')]")).get(0).getText(),
                "UK pledges support if Sweden were to be attacked");
    }

    @Test(priority = 1)
    public void checkFirstFiveSecondaryArticles(){
        List<String> articles = new ArrayList<>();
        articles.add("Russia pushed back in north-east - report from front line");
        articles.add("Emotions run high as Ukraine heads for Eurovision final");
        articles.add("Sri Lanka's ex-PM flees to naval base amid protests");
        articles.add("Al Jazeera reporter killed during Israeli raid");
        articles.add("Anti-mafia prosecutor killed on honeymoon");

        driver.findElement(By.xpath("//nav[@class='orbit-header-links international']//span[text()='News']")).click();

        for(int i = 0; i < articles.size(); i++){
            assertEquals(articles.get(i), driver.findElements(By.xpath("//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']")).get(i).getText());
        }
    }

    @Test(priority = 2)
    public void checkNameOfFirstArticleAfterSearching(){
        driver.findElement(By.xpath("//nav[@class='orbit-header-links international']//span[text()='News']")).click();
        String searchText = driver.findElement(By.xpath("//a[@class='nw-o-link']/span[contains(text(), 'Coronavirus')]")).getText();
        driver.findElement(By.xpath("//a[@id='orbit-search-button']")).click();
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(searchText);
        driver.findElement(By.xpath("//button[@data-testid='test-search-submit']")).click();
        String expectedResult = "Ministers give coronavirus restrictions update";

        assertEquals(expectedResult, driver.findElements(By.xpath("//span[@role='text']//span")).get(0).getText());
    }

}
