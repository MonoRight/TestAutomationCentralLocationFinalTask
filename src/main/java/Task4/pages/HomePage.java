package Task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//nav[@class='orbit-header-links international']//span[text()='News']")
    private WebElement newsCategory;
    @FindBy(xpath = "//nav[@class='orbit-header-links international']//span[text()='Sport']")
    private WebElement sportCategory;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNewsCategory(){
        return newsCategory;
    }
    public WebElement getSportCategory(){
        return sportCategory;
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

}
